
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

public class membersList {
	private ArrayList<Members> members;
	
	public membersList() 
	{
		members = new ArrayList<>();
	}
	public void add(Members member) {
		members.add(member);
	}
	
	public void readCSVFile(String filename) {
		try {	//Creates a FileReader wrapped BufferedReader
				BufferedReader br = new BufferedReader(new FileReader(filename));	
				//Reads files line by line.
				String line = null;
				//Error thrown if value being read = null
				while ((line = br.readLine()) != null) {
					String[] tokens = line.split(",");
					int MemberID = Integer.parseInt(tokens[0]);
					String firstName = tokens[1].trim();
					String surname = tokens[2].trim();
					String DateOfBirth = tokens[3].trim();
					String email = tokens[4].trim();
					String telephone = tokens[5].trim();
					String mobile = tokens[6].trim();
					Members newMember = new Members(MemberID, firstName, surname, DateOfBirth, email, telephone, mobile);
					members.add(newMember);
				}
			}
			catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}//End readCSVFile
	
	public ArrayList<Members> getMembers(){
		return members;
	}
	
	public int idGenerator(){
		int id = (int) (new Date()).getTime();
		return id;
	}
	
	public void delete( int MemberID) throws IOException 
	{
		for (int x = 0; x < members.size(); x++)
		{
			if (members.get(x).getMemberID() == MemberID)
				members.remove(x);
		}
			
	}//End delete()
	
	public void edit(Members updateMember){
		for (Members member:members){
			if (member.getMemberID() == updateMember.getMemberID()){
				member.setMemberID(updateMember.getMemberID());
				member.setFirstName(updateMember.getFirstName());
				member.setSurname(updateMember.getSurname());
				member.setDateOfBirth(updateMember.getDateOfBirth());
				member.setEmail(updateMember.getDateOfBirth());
				member.setTelephone(updateMember.getTelephone());
				member.setMobile(updateMember.getMobile());	
			}
		}
	}
	
	
	
	public void deleteWriter() {
		try {
		BufferedWriter br = new BufferedWriter(new FileWriter("MembersList.csv"));
		for (int x = 0; x < members.size(); x++){
			Members member = members.get(x);
			br.write(Integer.toString(member.getMemberID()) + ",");
			br.write(member.getFirstName()  + ",");
			br.write(member.getSurname() + ",");
			br.write(member.getDateOfBirth() + ",");
			br.write(member.getEmail() + ",");
			br.write(member.getTelephone() + ",");
			br.write(member.getMobile());
			br.newLine();
		}
		br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//End deleteWriter()
}

