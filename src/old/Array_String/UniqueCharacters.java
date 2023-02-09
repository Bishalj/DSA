package old.Array_String;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class UniqueCharacters {

  public static void main(String[] args) {
//	  old.String s = "abcdert";
//
//
//	  System.out.println(isWordUnique(s));
//
//	  old.String s1 = "abcdbjde";
//	  System.out.println(isWordUnique(s1));

	  HttpClient client = HttpClient.newBuilder().build();
    String body =
        "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
            + "    <Body>\n"
            + "        <serve xmlns=\"http://schemas.cordys.com/gateway/Provider\">\n"
            + "            <SessionDoc>\n"
            + "                <Session>\n"
            + "                    <SessionData xmlns=\"http://schemas.cordys.com/bagi/b2c/emotor/bpm/1.0\">\n"
            + "                        <Index>1</Index>\n"
            + "                        <InitTime>Mon, 07 Jun 2021 13:40:41 GMT</InitTime>\n"
            + "                        <UserName>paytMtr</UserName>\n"
            + "                        <Password>5WuGV5D/OOH25mml4f3koZ2mC8i0p104cUuZA7P0L8jDHZ35j8VYiihvnZXx5O+9eRHhqJDgxd+UT9s4hdBu/Q==</Password>\n"
            + "                        <OrderNo>NA</OrderNo>\n"
            + "                        <QuoteNo>NA</QuoteNo>\n"
            + "                        <Route>INT</Route>\n"
            + "                        <Contract>MTR</Contract>\n"
            + "                        <Channel></Channel>\n"
            + "                        <TransactionType>Quote</TransactionType>\n"
            + "                        <TransactionStatus>Fresh</TransactionStatus>\n"
            + "                        <ID>1234567</ID>\n"
            + "                        <UserAgentID></UserAgentID>\n"
            + "                        <Source></Source>\n"
            + "                    </SessionData>\n"
            + "                    <tns:Vehicle xmlns:tns=\"http://schemas.cordys.com/bagi/b2c/emotor/2.0\">\n"
            + "                        <tns:TypeOfBusiness>TR</tns:TypeOfBusiness>\n"
            + "                        <tns:AccessoryInsured>N</tns:AccessoryInsured>\n"
            + "                        <tns:AccessoryValue>0</tns:AccessoryValue>\n"
            + "                        <tns:NonElecAccessoryInsured>N</tns:NonElecAccessoryInsured>\n"
            + "                        <tns:NonElecAccessoryValue>0</tns:NonElecAccessoryValue>\n"
            + "                        <tns:BiFuelKit>\n"
            + "                            <tns:IsBiFuelKit>N</tns:IsBiFuelKit>\n"
            + "                            <tns:BiFuelKitValue>0</tns:BiFuelKitValue>\n"
            + "                            <tns:ExternallyFitted>N</tns:ExternallyFitted>\n"
            + "                        </tns:BiFuelKit>\n"
            + "                        <tns:DateOfManufacture>2017</tns:DateOfManufacture>\n"
            + "                        <tns:DateOfRegistration>2017-06-01T00:00:00.000</tns:DateOfRegistration>\n"
            + "                        <tns:RiskType>FTW</tns:RiskType>\n"
            + "                        <tns:Make>HONDA MOTORS</tns:Make>\n"
            + "                        <tns:Model>ACTIVA</tns:Model>\n"
            + "                        <tns:FuelType>P</tns:FuelType>\n"
            + "                        <tns:Variant>3G</tns:Variant>\n"
            + "                        <tns:IDV>0</tns:IDV>\n"
            + "                        <tns:VehicleAge>4</tns:VehicleAge>\n"
            + "                        <tns:CC>109</tns:CC>\n"
            + "                        <tns:PlaceOfRegistration>Mumbai Andheri</tns:PlaceOfRegistration>\n"
            + "                        <tns:SeatingCapacity>2</tns:SeatingCapacity>\n"
            + "                        <tns:VehicleExtraTag01 />\n"
            + "                        <tns:RegistrationNo></tns:RegistrationNo>\n"
            + "                        <tns:ExShowroomPrice>51800</tns:ExShowroomPrice>\n"
            + "                    </tns:Vehicle>\n"
            + "                    <tns:Quote xmlns:tns=\"http://schemas.cordys.com/bagi/b2c/emotor/2.0\">\n"
            + "                        <tns:ExistingPolicy>\n"
            + "                            <tns:Claims>0</tns:Claims>\n"
            + "                            <tns:PolicyType>Comprehensive</tns:PolicyType>\n"
            + "                            <tns:EndDate>2021-07-09T00:00:00.000</tns:EndDate>\n"
            + "                            <tns:NCB>45</tns:NCB>\n"
            + "                        </tns:ExistingPolicy>\n"
            + "                        <tns:PolicyStartDate>2021-07-10T00:00:00.000</tns:PolicyStartDate>\n"
            + "                        <tns:Deductible>0</tns:Deductible>\n"
            + "                        <tns:PAFamilySI>10000</tns:PAFamilySI>\n"
            + "                        <tns:AgentNumber />\n"
            + "                        <tns:DealerId />\n"
            + "                        <tns:Premium>\n"
            + "                            <tns:Discount />\n"
            + "                        </tns:Premium>\n"
            + "                        <tns:SelectedCovers>\n"
            + "                            <ZeroDepriciationSelected>true</ZeroDepriciationSelected>\n"
            + "                            <PADriverSelected>true</PADriverSelected>\n"
            + "                        </tns:SelectedCovers>\n"
            + "                        <tns:PolicyEndDate>2022-07-09T23:59:59.999</tns:PolicyEndDate>\n"
            + "                        <IsExistingPA>false</IsExistingPA>\n"
            + "                        <PADeclaration />\n"
            + "                    </tns:Quote>\n"
            + "                    <tns:Client xmlns:tns=\"http://schemas.cordys.com/bagi/b2c/emotor/2.0\">\n"
            + "                        <tns:ClientType>Individual</tns:ClientType>\n"
            + "                        <tns:GivName>1234567</tns:GivName>\n"
            + "                        <tns:SurName />\n"
            + "                        <tns:ClientExtraTag01>Maharashtra</tns:ClientExtraTag01>\n"
            + "                        <tns:CityOfResidence>Mumbai Andheri</tns:CityOfResidence>\n"
            + "                        <tns:EmailID>pb@pb.com</tns:EmailID>\n"
            + "                        <tns:MobileNo>9999999999</tns:MobileNo>\n"
            + "                        <tns:RegistrationZone>A</tns:RegistrationZone>\n"
            + "                    </tns:Client>\n"
            + "                </Session>\n"
            + "            </SessionDoc>\n"
            + "        </serve>\n"
            + "    </Body>\n"
            + "</Envelope>";
	  HttpRequest request = HttpRequest.newBuilder()
			  .uri(URI.create("https://awpservices.bhartiaxaonline.co.in/home/B2C/com.eibus.web.soap.Gateway.wcp?organization=o=B2C,cn=cordys,cn=PROD01,o=axa-in.intraxa"))
			  .POST(HttpRequest.BodyPublishers.ofString(body))
			  .version(HttpClient.Version.HTTP_1_1)
			  .setHeader("Content-Type", "application/xml")
			  .setHeader("Content-Type", "application/xml")
			  .build();

	  HttpResponse<?> response = null;
	  try {
		  response = client.send(request, HttpResponse.BodyHandlers.discarding());
	  } catch (IOException e) {
		  e.printStackTrace();
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  System.out.println(response.statusCode());
  }

	private static Boolean isWordUnique(String s) {
		int arr[] = new int[26];
		for(int i = 0; i< s.length(); i++)
			arr[s.charAt(i)-97]++;
		for(int i=0; i<26; i++){
			if(arr[i] >= 2)
				return false;
		}
		return true;
	}
}


class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		Comparator<Pair> comparator = (p1,p2) -> {
			if(p1.getKey() == p2.getKey())
			return p2.getValue() < p1.getValue() ? 1 : -1;
			else
			return p2.getKey() < p1.getKey() ? 1 : -1;
		};
		PriorityQueue<Pair> pq = new PriorityQueue(k,comparator);

		for(int i=0; i<arr.length; i++){
			pq.add(new Pair(Math.abs(arr[i] - x), i));
		}
		Set<Integer> set = new HashSet();
		while(pq.isEmpty() == false){
			Pair data = pq.poll();
			set.add(data.getValue());
		}
		List<Integer> result = new ArrayList();
		for(int i=0; i<arr.length; i++){
			if(set.contains(i))
				result.add(arr[i]);
		}
		return result;
	}
}

class Pair{
	private int key;
	private int value;

	public Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}


class Solution2 {
  public static void main(String[] args) {
	System.out.println(customSortString("cba", "abcd"));
  }

	public static  String customSortString(String order, String str) {
		Set<Character> orderSet = getSet(order);
		Set<Character> strSet = getSet(str);
		ArrayList<String> arr = new ArrayList();
		for(Character ch : orderSet){
			System.out.println("------------------------" + ch);
			if(strSet.contains(ch))
				arr.add(String.valueOf(ch));
		}

		int i=0;
		StringBuilder stb = new StringBuilder();
		for(Character ch : strSet){
			if(!orderSet.contains(ch))
				stb.append(ch);
			else if(i<arr.size() && String.valueOf(ch).equals(arr.get(i)))
				stb.append(arr.get(i++));
		}
		return stb.toString();
	}

	private static Set<Character> getSet(String order) {
  	    Set<Character> set = new LinkedHashSet<>();
  	    for(int i=0; i<order.length(); i++)
			set.add(order.charAt(i));
  	    return set;
	}
}