package ATM_;

import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Atm {
	// Atm yi user kullanacagý ýcýn user nesnesý burada olusturuldu. (atm user ile varoluyor)
	private User user;
	private ArrayList<User> users = new ArrayList(); 
	int userIndex;
	int sec;

	public Atm(){
		
		users.add(new User("111",1234, 200));
		users.add(new User("222",1235, 500));
		
	}
	private boolean isLogin = false;
	
	



	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public boolean isLogin() {
		return isLogin;
	}


	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}


	public Atm(User user) {
		this.user = user;
	}

	
	public ArrayList<User> getOgrenciListesi() {
		return users;
	}
	public void setOgrenciListesi(ArrayList<User> ogrenciListesi) {
		this.users = ogrenciListesi;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	// Login
	// para çek
	// para yatýr
	// logout

	public void login(User user) {
		
		boolean hesapNoDogru = false;
		boolean sifreDogru = false;
		
		while(!hesapNoDogru) {
			/////  HESAP NUMARASI  /////////////////////
			System.out.println("KART NO: ");
			Scanner inputcard = new Scanner(System.in);
			String accountNumber = inputcard.nextLine();
			
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getAccountNumber().equals(accountNumber)) {
					hesapNoDogru = true;
					userIndex = i;
					break;
				}
				else {
					hesapNoDogru = false;
				}
			}
			if(!hesapNoDogru) {
				System.out.println("Hesap Numarasi Hatali, Tekrar Deneyin");
			}
			
		}
		
		while(hesapNoDogru && !sifreDogru) {
			/////  SIFRE  ///////////////////
			 System.out.println("SIFRE: ");
			 Scanner inputpass = new Scanner(System.in);
			 int password = inputpass.nextInt();
			 
			 for(int i = 0; i < users.size(); i++) {
					if(users.get(userIndex).getPassword() == password) {
						sifreDogru = true;
						isLogin = true;
						break;
					}
					else {
						sifreDogru = false;
					}
			 }
			 
			 if(!sifreDogru) {
					System.out.println("Sifre Hatali, Tekrar Deneyin");
			 }
		}
	}
		
	
	public void withdrawal() {  //para cekme
		
		 if(isLogin) {
			System.out.println("CEKÝLECEK MÝKTAR: ");
			Scanner input = new Scanner(System.in);
			double amount = input.nextDouble();
			
			if (amount < users.get(userIndex).getAmount()) {

				users.get(userIndex).setAmount(users.get(userIndex).getAmount() - amount);
				System.out.println("Kalan Bakiye: " + users.get(userIndex).getAmount());
			}else 
				System.out.println("Bakiye yetersiz !");// bakiyeden daha büyük miktar istendiði zaman
			
			}

		
	}
	
	

	public void cashDeposit() { //para yatýrma

		if (isLogin) {

	
		System.out.println("YATIRILACAK MÝKTAR: ");
		Scanner input  = new Scanner(System.in);
		double amount = input.nextDouble();
		
		this.users.get(userIndex).setAmount(this.users.get(userIndex).getAmount() + amount);
		System.out.println("Kalan Bakiye: " + users.get(userIndex).getAmount());
		
	}
				
	}
	
	
		
	public void reference() {
		
		System.out.println("Havale yapacagýnýz  kisinin hesap numarasý: ");
		Scanner input = new Scanner(System.in);
		String amountNo = input.nextLine();
		
		System.out.println("Göndermek istediðiniz miktarý giriniz: ");
		Scanner reference = new Scanner(System.in);
		double account = reference.nextDouble();
		if (account < this.users.get(userIndex).getAmount()) {
			System.out.println(account + "Hesabýna göderildi");
			this.users.get(userIndex).setAmount(this.users.get(userIndex).getAmount() - account);
			System.out.println("Kalan Bakiye: " + users.get(userIndex).getAmount());
		}else 
			System.out.println("Bakiye yetersiz !");// bakiyeden daha büyük miktar istendiði zaman
		}
		
		
		
		
		
	
	
	
	public void currentBalance() { ///Güncel Bakiye
		
		System.out.println("BAKIYE: " + this.users.get(userIndex).getAmount());
		

	}
	
	public void changePassword() {
	
		Scanner input  = new Scanner(System.in);
		System.out.println("Eski Sifre: ");
		int password = input.nextInt();
		
		if(password == this.users.get(userIndex).getPassword()) {
		
		Scanner newinput  = new Scanner(System.in);
		System.out.println("Yeni Sifre: ");
		int newpassword = newinput.nextInt();
		this.users.get(userIndex).setPassword(newpassword);
		System.out.println("Sifreniz Degistirildi");
		
		} else
			System.out.println("Gecerli sifreyi hatalý girdiniz !");
		
	}
	
	public void logout() {
		isLogin = false;
		System.out.println("CIKIS YAPILDI");
	}
	
}
