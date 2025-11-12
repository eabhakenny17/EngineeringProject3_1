package eventManager;
import java.util.ArrayList;

public class AllAdminAccounts {
	private ArrayList<AdminAccount> adminAccountsList = new ArrayList<AdminAccount>();
	
	public ArrayList<AdminAccount> getAdminAccountsList() {
		return adminAccountsList;
	}

	public void setAdminAccountsList(ArrayList<AdminAccount> adminAccountsList) {
		this.adminAccountsList = adminAccountsList;
	}

	public AllAdminAccounts() {
		AdminAccount Admin1 = new AdminAccount("Samson", "password", 1);
		AdminAccount Admin2 = new AdminAccount("Éabha", "password", 2);
		AdminAccount Admin3 = new AdminAccount("Jack", "password", 3);
		
		adminAccountsList.add(Admin1);
		adminAccountsList.add(Admin2);
		adminAccountsList.add(Admin3);
	}
}
