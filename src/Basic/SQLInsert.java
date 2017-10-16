package Basic;

public class SQLInsert {
	public static void main(String[] args) {
		String INSTALL_GU_NAME = "CAB-E&M-TB'R17";
		if(INSTALL_GU_NAME.contains("'")) {//' creating string not properly ended issue
			INSTALL_GU_NAME = INSTALL_GU_NAME.replaceAll("'", "''");
		}
		if(INSTALL_GU_NAME.contains("&")) {//'THE GOODYEAR TIRE ' || '&' || ' RUBBER COMPANY'
			INSTALL_GU_NAME = INSTALL_GU_NAME.replaceAll("&", "' || '&' ||'");
		}
		System.out.println("INSTALL_GU_NAME=="+INSTALL_GU_NAME);
	}
}
