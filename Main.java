
public class Main {
	
	private String removeAccent(String s) {
		
		char[] c = s.toCharArray();
		for(int i=0; i<s.length();i++) {
			if((int) c[i]>=224 && (int) c[i]<= 229) c[i]='a';
				else if((int) c[i]>=232 && (int) c[i]<= 235) c[i]='e';
					else if((int) c[i]>=236 && (int) c[i]<= 239) c[i]='i';
						else if((int) c[i]>=240 && (int) c[i]<= 246) c[i]='o';
							else if((int) c[i]>=249 && (int) c[i]<= 252) c[i]='u'; 
		}
		s = String.valueOf(c);
		return s;
		
		
	}
		
	}


