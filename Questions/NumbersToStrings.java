package Questions;

public class NumbersToStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="2037";
		
		char c[]=s.toCharArray();
		
		String single_digit[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String two_digit[]= {"","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String ten_multiples[]= {"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
		String tens_power[]= {"hundred","thousand"};

		conver(c,single_digit,two_digit,ten_multiples,tens_power);
	}
	
	public static void conver(char c[],String single_digit[],String two_digit[],String ten_multiples[],String tens_power[])
	{
		int n=c.length;
		int n2=n;
		
		if(n==0 || n>4)
		{
			System.out.println("Invalid String");
			return;
		}
		
		if(n==1)
		{
			System.out.println(single_digit[c[0]-'0']);
			return;
		}
		
		int i=0;
		
		while(i<n)
		{
			if(n2>=3)
			{
				if(c[i]-'0'!=0)
				{
					System.out.print(single_digit[c[i]-'0']+" "+tens_power[n-3]+" ");
				}
				n2--;
			}
			else
			{
				//10-19
				if(c[i]-'0'==1)
				{
					int sum=c[i]-'0'+c[i+1]-'0';
					System.out.print(two_digit[sum]+" ");
					return;
				}
				//20
				else if(c[i]-'0'==2 && c[i+1]-'0'==0)
				{
					System.out.print("twenty ");
					return;
				}
				//21-99
				else
				{
					int x=c[i]-'0';
					if(x>0)
					{
						System.out.print(ten_multiples[x]+" ");
					}
					else
					{
						System.out.print("");
					}
					i++;
					if(c[i]-'0'!=0)
					{
						System.out.print(single_digit[c[i]-'0']);
					}
					return;
				}
				
			}
			i++;
		}
	}


}
