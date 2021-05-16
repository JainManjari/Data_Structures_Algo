package Machine_Code;
import java.util.*;

class Person
{
	String name;
	String id;
	int totalOwnedAmout;
}

class PaidDetails
{
	int amt;
	String personId;
}

class Bill
{
	int total;
	PaidDetails ContriList[];
	PaidDetails paidByPer[];
	String name;
	String groupId;
	PaidDetails ownedDetailsGroups[];
}

class Group
{
	String name;
	String id;
	String members[];
	PaidDetails ownedDetailsGroups[];
	Bill[] bills;
}

public class SplitWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter no of persons");
		int n=in.nextInt();
		Person p[]=new Person[n];
		for(int i=0;i<n;i++)
		{
			p[i]=new Person();
			System.out.println("Enter email id of person "+(i+1)+":");
			p[i].id=in.next();
			System.out.println("Enter name: ");
			p[i].name=in.next();
		}
		
		System.out.println("Enter no of groups");
		int noOfGroups=in.nextInt();
		Group g[]=new Group[noOfGroups];
		for(int i=0;i<noOfGroups;i++)
		{
			g[i]=new Group();
			//System.out.println("Enter group id: ");
			g[i].id="group"+(i+1);
			System.out.println("Enter group name: ");
			g[i].name=in.next();
			System.out.println("Enter total members of groups");
			int noOfmembers=in.nextInt();
			g[i].members=new String[noOfmembers];
			g[i].ownedDetailsGroups=new PaidDetails[noOfmembers];
			for(int j=0;j<noOfmembers;j++)
			{
				System.out.println("Enter email id of a member for group "+(i+1));
				g[i].members[j]	=in.next();
			}
		}
		
		for(int i=0;i<noOfGroups;i++)
		{
			Group grp=g[i];
			System.out.println("Enter total no of bills for group "+(i+1));
			int noOfBills=in.nextInt();
			g[i].bills=new Bill[noOfBills];
			for(int j=0;j<noOfBills;j++)
			{
				System.out.println("Enter total amout of bill");
				g[i].bills[j]=new Bill();
				g[i].bills[j].total=in.nextInt();
				g[i].bills[j].name="bill"+(j+1);
				System.out.println("Enter grp id of bill");
				g[i].bills[j].groupId=in.next();
				System.out.println("Enter total no of contributions for bill"+(j+1));
				int noOfContri=in.nextInt();
				g[i].bills[j].ContriList=new PaidDetails[noOfContri];
				g[i].bills[j].ownedDetailsGroups=new PaidDetails[noOfContri];
				for(int k=0;k<noOfContri;k++)
				{
					g[i].bills[j].ContriList[k]=new PaidDetails();
					System.out.println("Enter person id for contri "+(k+1));
					g[i].bills[j].ContriList[k].personId=in.next();
					System.out.println("Enter amt for contri "+(k+1));
					g[i].bills[j].ContriList[k].amt=in.nextInt();
					
				}
				System.out.println("Enter total no of payers for bill"+(j+1));
				int noOfPayers=in.nextInt();
				g[i].bills[j].paidByPer=new PaidDetails[noOfPayers];
				for(int k=0;k<noOfPayers;k++)
				{
					g[i].bills[j].paidByPer[k]=new PaidDetails();
					System.out.println("Enter person id for totalpay "+(k+1));
					g[i].bills[j].paidByPer[k].personId=in.next();
					System.out.println("Enter amt for totalpay "+(k+1));
					g[i].bills[j].paidByPer[k].amt=in.nextInt();
					
				}
			}
			
		}
		
		finalSplit(g);
		
	    
	}
	
	public static void finalSplit(Group g[])
	{
		for(int i=0;i<g.length;i++)
		{
			Bill b[]=g[i].bills;
			//PaidDetails totalPersonShareInGroup[]=g[i].ownedDetailsGroups;
			ArrayList<PaidDetails> totalsBills=new ArrayList();
			for(int j=0;j<b.length;j++)
			{
				billWise(b[j]);
			}
			for(int j=0;j<b.length;j++)
			{
				for(int k=0;k<b[j].ownedDetailsGroups.length;k++)
				{
					totalsBills.add(b[j].ownedDetailsGroups[k]);
				}
			}
			groupWise(totalsBills,g[i]);
		}
		ArrayList<PaidDetails> totalsPersonBills=new ArrayList();
		for(int i=0;i<g.length;i++)
		{
			PaidDetails p[]=g[i].ownedDetailsGroups;
			for(int j=0;j<p.length;j++)
			{
				totalsPersonBills.add(p[j]);
			}
		}
		
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		
		for(int i=0;i<totalsPersonBills.size();i++)
		{
			if(map.containsKey(totalsPersonBills.get(i).personId))
			{
				map.put(totalsPersonBills.get(i).personId, map.get(totalsPersonBills.get(i).personId)+totalsPersonBills.get(i).amt);
			}
			else
			{
				map.put(totalsPersonBills.get(i).personId, totalsPersonBills.get(i).amt);
			}
		}
		
		for(String s:map.keySet())
		{
			System.out.println("Person info "+s+" "+map.get(s));
		}
	}
	
	public static void groupWise(ArrayList<PaidDetails> billPaidDetails,Group g)
	{
		PaidDetails[] groupOwnedDetails=g.ownedDetailsGroups;
		System.out.println("bill size "+billPaidDetails.size());
		for(int l=0;l<g.members.length;l++)
		{
			groupOwnedDetails[l]=new PaidDetails();
			groupOwnedDetails[l].personId=g.members[l];
			groupOwnedDetails[l].amt=0;
			for(int i=0;i<billPaidDetails.size();i++)
			{
				
//				for(int j=i+1;j<billPaidDetails.size();j++)
//				{
					if(billPaidDetails.get(i).personId.matches(groupOwnedDetails[l].personId))
					{
						groupOwnedDetails[l].amt+=billPaidDetails.get(i).amt;
					}
				
			}
		}
		
		
		System.out.println("grp info "+g.name);
		for(int i=0;i<g.ownedDetailsGroups.length;i++)
		{
			System.out.println(g.ownedDetailsGroups[i].personId+" "+g.ownedDetailsGroups[i].amt);
		}
	}
	
	public static void billWise(Bill b)
	{
		PaidDetails paid[]=b.ownedDetailsGroups;
		PaidDetails contries[]=b.ContriList;
		PaidDetails shares[]=b.paidByPer;
		
		for(int i=0;i<contries.length;i++)
		{
			paid[i]=new PaidDetails();
			paid[i].personId=contries[i].personId;
		    paid[i].amt=split(contries[i].personId,contries[i].amt,shares);
		}
		System.out.println("bill info "+b.name+" "+b.groupId);
		for(int i=0;i<b.ownedDetailsGroups.length;i++)
		{
			System.out.println(b.ownedDetailsGroups[i].personId+" "+b.ownedDetailsGroups[i].amt);
		}
 	}
	
	public static int split(String pID,int amt,PaidDetails s[])
	{
		int amount=amt;
		for(int i=0;i<s.length;i++)
		{
			System.out.println("share "+s[i].personId+" "+s[i].amt+" "+amount+" "+pID);
			if(s[i].personId.matches(pID))
			{
				System.out.println("found");
				amount=s[i].amt-amt;
				return amount;
			}
		}
		return -amount;
	}

}

/*
 * 
 * 
3
p1@
p1
p2@
p2
p3@
p3
2
g1
2
p1@
p2@
g2
2
p2@
p3@
2
300
g1
2
p1@
100
p2@
200
1
p1@
300
500
g2
2
p1@
250
p2@
250
1
p2@
500
2
100
g2
2
p2@
10
p3@
90
1
p3@
100
300
g2
2
p2@
150
p3@
150
2
p3@
100
p2@
200
 * 
 */
