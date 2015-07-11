import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ICPCS {

	static int tp[], fa[], countSolved[], teams, problems;
	static final int DEFAULT_PENALTY = 20, INFINITY= 1000000;
	static int newPenalty;
	static Score[] defaultRank;
	static Score[] newRank;

	static class Score implements Comparable<Score>{
		int teamID;
		public Score(int id){
			teamID = id;
		}
		@Override
		public int compareTo(Score o) {
			if(countSolved[teamID] != countSolved[o.teamID]){
				return countSolved[o.teamID] - countSolved[teamID];
			}
			int mine = tp[teamID] + newPenalty*fa[teamID];
			int other =  tp[o.teamID] + newPenalty*fa[o.teamID];
			return mine - other;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out = new StringBuffer();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			teams = new Integer(st.nextToken());
			problems = new Integer(st.nextToken());
			if(teams ==0  && problems == 0)
				break;
			tp=  new int[teams];
			fa= new int[teams];
			countSolved= new int[teams];

			defaultRank = new Score[teams];
			newRank = new Score[teams];

			for (int i = 0; i < teams; i++) {
				st = new StringTokenizer(br.readLine());
				defaultRank[i] = new Score(i);
				newRank[i] = new Score(i);

				for (int j = 0; j < problems; j++) {
					String s[] = st.nextToken().split("/");
					if(s[1].equals("-"))
						continue;
					countSolved[i]++;
					tp[i] += new Integer(s[1]);
					fa[i] += new Integer(s[0])-1;
				}
			}

			newPenalty = DEFAULT_PENALTY;
			Arrays.sort(defaultRank);

			int lowBound = 20;
			//1 because the problem statement says
			//it has to be a positive integer
			int low = 1;
			int high = 19;
			while(low <= high){
				int mid  = low + (high-low)/2;
				if(checkSameRanks(mid)){
					lowBound = Math.min(lowBound, mid);
					high = mid -1;
				}
				else{
					low =  mid+1;
				}
			}
			out.append(lowBound);
			out.append(' ');

			int upperBound = 20;
			//1 because the problem statement says
			//it has to be a positive integer
			low = 21;
			high = INFINITY;
			while(low <= high){
				int mid  = low + (high-low)/2;
				if(checkSameRanks(mid)){
					upperBound = Math.max(upperBound, mid);
					low =  mid+1;
				}
				else{
					high = mid -1;
				}
			}
			if(upperBound == INFINITY){
				out.append('*');
			}
			else{
				out.append(upperBound);
			}
			out.append('\n');
		}
		System.out.print(out);
	}

	static boolean sameRelativeRank(int r1, int r2){
		return r1 ==0  && r2 == 0
				|| r1>0 && r2>0
				|| r1<0 && r2<0;
	}

	static boolean checkSameRanks(int newVal){
		newPenalty = newVal;
		Arrays.sort(newRank);
		for (int i = 0; i < defaultRank.length; i++) {
			if(defaultRank[i].teamID != newRank[i].teamID)
				return false;
			if(i>0){
				newPenalty = DEFAULT_PENALTY;
				int r1 = defaultRank[i].compareTo(defaultRank[i-1]);
				newPenalty = newVal;
				int r2 = newRank[i].compareTo(newRank[i-1]); 
				if(!sameRelativeRank(r1,r2))
					return false;
			}
		}
		return true;

	}
}
