
package com.enumtech.waterworks.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enumtech.waterworks.entity.Attendance;
import com.enumtech.waterworks.entity.Employee;
import com.enumtech.waterworks.entity.InwardSource;
import com.enumtech.waterworks.entity.InwardTrans;
import com.enumtech.waterworks.entity.MonthlySubscription;
import com.enumtech.waterworks.entity.OutwardSource;
import com.enumtech.waterworks.entity.OutwardTrans;
import com.enumtech.waterworks.entity.Product;
import com.enumtech.waterworks.entity.SubTrans;
import com.enumtech.waterworks.entity.Subscriber;
import com.enumtech.waterworks.entity.ThirdParty;
import com.enumtech.waterworks.entity.Zone;
import com.enumtech.waterworks.repository.SubsRepo;
import com.enumtech.waterworks.service.AttdService;
import com.enumtech.waterworks.service.EmployeeService;
import com.enumtech.waterworks.service.InwardSourceService;
import com.enumtech.waterworks.service.InwardTransService;
import com.enumtech.waterworks.service.MonthlySubService;
import com.enumtech.waterworks.service.OutwardSourceService;
import com.enumtech.waterworks.service.OutwardTransService;
import com.enumtech.waterworks.service.ProductService;
import com.enumtech.waterworks.service.SubsService;
import com.enumtech.waterworks.service.ThirdPartyService;
import com.enumtech.waterworks.service.TransService;
import com.enumtech.waterworks.service.ZoneService;

@RestController
@RequestMapping("/waterwork")
public class WaterWorkController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	SubsService subsService;

	@Autowired
	ZoneService zoneService;

	@Autowired
	ThirdPartyService tpservice;

	@Autowired
	MonthlySubService msservice;

	@Autowired
	AttdService attdserv;
    
	@Autowired
	ProductService productService;
	
	
	//@Value("${myname}")
	//private String myName;
	
	
	// employee controller
	
	@RequestMapping("/welcome")
	public String greet()
	{
		return "login successfully";
	}
	@RequestMapping("/accessDenied")
	public String accessDenied()
	{
		return " accessDenied 403 ";
	}
	
	@RequestMapping("/add/insertEmployee")
	public Employee insertCourse(@RequestBody Employee employee) {

		return employeeService.insertEmployee(employee);
	}

	@RequestMapping("/delete/deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam("empNo") long empNo) {
		employeeService.deleteEmployeeById(empNo);
		return " Record Deleted Succesfully";
	}

	@RequestMapping("/update/updateEmployeeById")
	public Employee updateEmployeeById(@RequestParam("empNo") long empNo, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(empNo, employee);
	}

	@RequestMapping("/get/getEmployeeByName")
	public Employee getEmployeeByName(@RequestParam("empName") String empName) {
		return employeeService.getEmployeeByName(empName);
	}

	@RequestMapping("/get/getByEmployeeNo")
	public Optional<Employee> getByEmployeeNo(@RequestParam("empNo") long empNo) {
		return employeeService.getByEmployeeNo(empNo);
	}

	@RequestMapping("/get/getEmployeeByAdharNo")
	public Employee getEmployeeByAdharNo(@RequestParam("empAdharNo") long empAdharNo) {
		return employeeService.getEmployeeByAdharNo(empAdharNo);
	}

	@RequestMapping("/get/getEmployeeByMobileNo")
	public Employee getEmployeeByMobileNo(@RequestParam("empMobileNo") long empMobileNo) {
		return employeeService.getEmployeeByMobileNo(empMobileNo);
	}

	@RequestMapping("/get/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	// gausiya//subscriber

	@RequestMapping("/add/addSubscriber")
	public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
		return subsService.addSubscriber(subscriber);
	}

	@RequestMapping("/get/getSubscriberByNo")
	public Subscriber getSubscriberByNo(@RequestParam("subscriberNo") int subscriberNo) {
		return subsService.getSubscriberByNo(subscriberNo);
	}

	@RequestMapping("/get/getAllSubscriber")
	public List<Subscriber> getAllSubscriber() {
		return subsService.getAllSubscriber();
	}

	@RequestMapping("/get/getSubscribersbyzoneno")
	public List<Subscriber> getSubscriberByZoneno(@RequestParam("zoneno") int zoneno) {
		return subsService.getSubscriberByZoneno(zoneno);
	}

	@RequestMapping("/get/getSubscriberByName")
	public Subscriber getSubscriberByName(@RequestParam("subscriberFirstName") String subscriberFirstName) {
		return subsService.getSubscriberByName(subscriberFirstName);
	}

	@RequestMapping("/get/getSubscriberBymobileno")
	public Subscriber getSubscriberByMobileNo(@RequestParam("subscriberMobileNo") long subscriberMobileNo) {
		return subsService.getSubscriberByMobileNo(subscriberMobileNo);
	}

	@RequestMapping("/get/getSubscriberByAdharNo")
	public Subscriber getSubscriberByAdharNo(@RequestParam("subscriberAdharNo") long subscriberAdharNo) {
		return subsService.getSubscriberByAdharNo(subscriberAdharNo);
	}

	@RequestMapping("/delete/deleteSubscriberById")//problem
	public String deleteSubscriber(@RequestParam("subscriberNo") int subscriberNo) {
		//return "record deleted successfully";
		subsService.deleteSubscriber(subscriberNo);
		return "record deleted successfully";

	}
	

	
	@RequestMapping("/update/UpdatedRecord/{subscriberNo}")
	public  Subscriber updatedRecord(@PathVariable("subscriberNo") int subscriberNo,
			@RequestBody Subscriber subscriberUser) {
		//return "update successfully ";
		return subsService.updatedRecord(subscriberNo, subscriberUser);

	}


	@RequestMapping("/delete/deleteSubscriberByadharno")
	public String deleteSubscriber(@RequestParam("subscriberAdharNo") long subscriberAdharNo) {
		subsService.deleteSubscriberByAdharNo(subscriberAdharNo);
		return "record deleted successfully";

	}
	
	
	@RequestMapping("/get/getCrbBySubno")
	public int getCrbBySubno(@RequestParam("subscriberNo") int subscriberNo) {
	return	subsService.getCrbBySubno(subscriberNo);
		

	}
	
	//Defaulters
	
	@RequestMapping("/get/getdefaultersByAmt")
	public List<Subscriber> getdefaultersByAmt(@RequestParam("amt") int amt) {
	return	subsService.getdefaultersByAmt(amt);
		}
	
	@RequestMapping("/get/getdefaultersBySurname")
	public List<Subscriber> getdefaultersBySurname(@RequestParam("lastName") String lastName) {
	return	subsService.getdefaultersBySurname(lastName);
		}
	
	@RequestMapping("/get/getdefaultersByZone")
	public List<Subscriber> getdefaultersByZone(@RequestParam("zoneno") int zoneno) {
	return	subsService.getdefaultersByZone(zoneno);
		}
	
	
	
	// ZONE

	@RequestMapping("/add/addZone")
	public String addZone(

			@RequestParam("zonename") String zonename)

	{
		Zone zone = new Zone();
		zone.setZonename(zonename);
		zoneService.addZone(zone);
		return ("inserted successfully");

	}

	@RequestMapping("/get/getZone")
	public List<Zone> getZone() {
		return zoneService.getAllZone();
	}

	
	// ThirdParty // MonthlySubscription

	@RequestMapping(value="/add/addThirdParty",method = RequestMethod.POST)
	public ThirdParty addThirdParty(@RequestBody ThirdParty addThirddParty) {
		return tpservice.addThirdParty(addThirddParty);

	}

	@RequestMapping("/add/addMonthlyFee")
	public MonthlySubscription addMonthlySubscription(@RequestParam("monthlyfee") int monthlyfee) {
		MonthlySubscription ms = new MonthlySubscription();
		ms.setMonthlyfee(monthlyfee);
		return msservice.addMonthlySubscription(ms);
	}

	@RequestMapping("/get/getallThirdParty")
	public List<ThirdParty> getAllThirdParty() {
		return tpservice.getAllThirdParty();
	}

	@RequestMapping("/get/getSingleThirdPartyById")
	public Optional<ThirdParty> getSingleThirdPartyById(@RequestParam("contactid") int contactid) {
		return tpservice.getSingleThirdPartyById(contactid);
	}

	@RequestMapping("/get/getThirdPartyByName")
	public ThirdParty getThirdPartyByName(@RequestParam("name") String name) {
		return tpservice.getThirdPartyByName(name);
	}

	@RequestMapping("/delete/deleteThirdPartyById")
	public String deleteThirdPartyById(@RequestParam("contactid") int contactid) {
		tpservice.deleteThirdPartyById(contactid);
		return "Record Deleted";
	}

	@RequestMapping("/update/updateThirdPartyById")
	public ThirdParty updateThirdParty(@RequestParam("contactid") int contactid, @RequestBody ThirdParty tpuser) {
		return tpservice.updateThirdParty(contactid, tpuser);
	}

	@RequestMapping("/update/updateMonthlySubscriptionById")
	public MonthlySubscription updateMonthlySubscription(@RequestParam("subscriptionid") int subscriptionid,
			@RequestBody MonthlySubscription msuser) {
		return msservice.updateMonthlySubscription(subscriptionid, msuser);
	}

	@RequestMapping("/get/getallMonthlySubscription")
	public List<MonthlySubscription> getAllMonthlySubscription() {
		return msservice.getAllMonthlySubscription();
	}

	// Attendance Controller\\

	@RequestMapping("/add/registerAttd")
	public String registerAttd(@RequestBody Attendance attd) {
		attdserv.registerAttd(attd);

		// attd.setStatus("present");

		return "inserted";
	}

	@RequestMapping("/get/getAttdByEmpId")
	public List<Attendance> attById(@RequestParam("empNo") long empNo) {
		List<Attendance> attendlist = new ArrayList<Attendance>();
		attendlist = attdserv.getAttendById(empNo);
		return attendlist;

	}

	@RequestMapping("/get/getAllAttd")
	public List<Attendance> getAllAttd() {
		List<Attendance> attendlist = new ArrayList<Attendance>();
		attendlist = attdserv.getAllAttendance();
		return attendlist;
	}

	@RequestMapping("/get/getAttendByMobileNo")
	public List<Attendance> attendById(@RequestParam("empMobileNo") String empMobileNo) {
		List<Attendance> attendlist = new ArrayList<Attendance>();
		attendlist = attdserv.getAttendByMobile(empMobileNo);
		return attendlist;
	}

	@RequestMapping("/get/getAttendByName")
	public List<Attendance> attendByName(@RequestParam("emp_name") String emp_name) {
		List<Attendance> attendlist = new ArrayList<Attendance>();
		attendlist = attdserv.getAttendByName(emp_name);
		return attendlist;
	}
	
	//Transaction Controller
	@Autowired
	TransService transService;
	
	
	
	
	//@Autowired
	//SubTrans subtran;
	@Autowired
	SubsRepo subrepo;
	
	@PostMapping("/add/topup")
	public SubTrans addTransaction(@RequestBody SubTrans substrans) throws Exception
	{
	   //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");   
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		substrans.setTdate(dateWithoutTime);
		substrans.setParticular("TopUp");
		
		return transService.addTransaction(substrans);
	}
	
	@GetMapping("/get/getAllSumDebitFromToDate")
	public int getAllDebitFromtoDate(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate )
	{
		return transService.getAllDebitFromtoDate(fromtdate,totdate);
		
	}
	
	
	@PostMapping("/add/monthlyBillDebit")
	public List<SubTrans> deductTransaction() throws Exception
	{
	     
	   List<SubTrans> substrans=new ArrayList();
		
	   return transService.deductTransaction(substrans);
	}
	
	
	
	
	
   
   @GetMapping("/get/getAllTrans")   
   public List<SubTrans> getAllTrans(){
	   
	   return transService.getAllTrans();
   }
   
   
   
   
   
   @GetMapping("/get/getBySubsNo")
   public List<SubTrans> getBySubsNo(@RequestParam("subscriberNo")String subscriberNo) {
	   return transService.getBySubsNo(subscriberNo);
   }
   
   
   @GetMapping("/get/getByDate")
   public List<SubTrans> getByDate(@RequestParam("tdate") String tdate) throws Exception{
//	   SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
//	   Date date1=formatter1.parse(tdate);
//	   System.out.println(date1);
	   return transService.getByDate(tdate);
   }
   
   

   @GetMapping("/get/getFromToDateSubtrans/{subscriberNo}")
   public List<SubTrans> getFromToDate(@PathVariable("subscriberNo")int subscriberNo ,@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate) throws Exception{

	   return transService.getFromToDate(subscriberNo,fromtdate,totdate);
   }
   
   
   //inward source Controller
   @Autowired
   InwardSourceService inwardsourService; 
   
   @RequestMapping("/add/addInwardSource")
	public InwardSource addInwardSource(@RequestBody InwardSource inwardSource) {
		return inwardsourService.addInwardSource(inwardSource);
	}
   
   @RequestMapping("/get/getAllInwardSource")
	public List<InwardSource> getAllInwardSource() {
		return inwardsourService.getAllInwardSource();
	}
   
   @RequestMapping("/get/getByIdInwardSource")
	public Optional<InwardSource> getByIdInwardSource(@RequestParam("inwardSid")int inwardSid) {
		return inwardsourService.getByIdInwardSource(inwardSid);
	}
   
   @RequestMapping("/update/updateInwardSourceById")
	public InwardSource updateInwardSourceById(@RequestParam("inwardSid") int inwardSid, @RequestBody InwardSource isuser) {
		return inwardsourService.updateInwardSourceById(inwardSid, isuser);
	}
   
   
   @RequestMapping("/delete/deleteInwardSourceById")
	public String deleteInwardSourceById(@RequestParam("inwardSid") int inwardSid) {
	   inwardsourService.deleteInwardSourceById(inwardSid);
		return "Record Deleted";
	}
   @RequestMapping("/get/getByNameInwardSource")
	public InwardSource getByNameInwardSource(@RequestParam("inwardSname") String inwardSname) {
	   return inwardsourService.getByNameInwardSource(inwardSname);
		 
	}
   
   //inwardTrans Controller
   @Autowired
   InwardTransService inwardTransServ;
   
   @Value("${bottlecost}")
	private int bottlecost;
   
   @Value("${capcost}")
  	private int capcost;
  
   
   @RequestMapping("/add/addInwardTrans")
   public InwardTrans addInwardTrans(@RequestBody InwardTrans inwardtrans)throws Exception {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		inwardtrans.setTdate(dateWithoutTime);
		
		int wbs=inwardtrans.getInwardSid();//1
		int amt=inwardtrans.getTamount();
		//int wb=
		//int bottleamt=20;
		//int capamt=10;
				
		//Product product =productService.getProductById(wbs);
		//int wb=product.getProductId();
	
		if(wbs==1) {
			
			Product p1=productService.getProductById(wbs);
			int qty=p1.getProductQty();
			
			int updateqnt=amt/bottlecost;
			if(qty>0)
			{
			qty=qty-updateqnt;
			System.out.println(qty);
			p1.setProductQty(qty);
			}
		}
		else if(wbs==2)
		{
			Product p1=productService.getProductById(wbs);
			int qty=p1.getProductQty();
			int updateqnt=amt/capcost;
			if(qty>0)
			{

			qty=qty-updateqnt;
			System.out.println(qty);
			p1.setProductQty(qty);
			}
			
		}
		else{
			System.out.println("this is filter bottle sale");
		}
		
	   return inwardTransServ.addInwardTrans(inwardtrans);
   
		}
		
   
   @RequestMapping("/get/getInTransBySourceid")
   public List<InwardTrans> getInTransBySourceid(@RequestParam("inwardSid")int inwardSid) {
	   
	   return inwardTransServ.getInTransBySourceid(inwardSid);
   }
   
   @RequestMapping("/get/getAllInwardTrans")
   public List<InwardTrans> getAllInwardTrans() {
	   
	   return inwardTransServ.getAllInwardTrans();
   }
   
   @RequestMapping("/get/getByRecieptNo")
   public InwardTrans getByRecieptNo(@RequestParam("receiptno")int receiptno) {
	   
	   return inwardTransServ.getByRecieptNo(receiptno);
   }
   
   @GetMapping("/get/getInTransByDate")
   public List<InwardTrans> getInTransByDate(@RequestParam("tdate") String tdate) throws Exception{

	   return inwardTransServ.getInTransByDate(tdate);
   }
   

	@GetMapping("/get/getSumAmountFromToDate")
	public int getSumAmountFromToDate(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate )
	{
		return inwardTransServ.getSumAmountFromToDate(fromtdate,totdate);
		
	}
	
	@GetMapping("/get/totalrevenue")
	public int totalrevenue(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate )
	{
		return inwardTransServ.totalrevenue(fromtdate,totdate);
		
	}
	
	

	@GetMapping("/get/getinwardtransFromToDate")
	public List<InwardTrans> getinwardtransFromToDate(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate )
	{
		return inwardTransServ.getinwardtransFromToDate(fromtdate,totdate);
		
	}
	
	
	
   
   //Outward Source Controller
   
   @Autowired 
   OutwardSourceService outsourceServ;
   
   @RequestMapping("/add/addOutwardSource")
   public OutwardSource addOutwardSource(@RequestBody OutwardSource outwardsource) {
	   
	   return  outsourceServ.addOutwardSource(outwardsource);
   }
   @RequestMapping("/get/getAllOutwardSource")
  	public List<OutwardSource> getAllOutwardSource() {
  		return outsourceServ.getAllOutwardSource();
  	}
     
     @RequestMapping("/get/getByIdOutwardSource")
  	public Optional<OutwardSource> getByIdOutwardSource(@RequestParam("outwardSid")int outwardSid) {
  		return outsourceServ.getByIdOutwardSource(outwardSid);
  	}
     
    
    @RequestMapping("/delete/deleteOutwardSourceById")
 	public String deleteOutwardSourceById(@RequestParam("outwardSid") int outwardSid) {
    	outsourceServ.deleteOutwardSourceById(outwardSid);
 		return "Record Deleted";
 	}
    
    @RequestMapping("/update/updateOutwardSourceById")
  	public OutwardSource updateOutwardSourceById(@RequestParam("outwardSid") int outwardSid, @RequestBody OutwardSource outSource) {
  		return outsourceServ.updateOutwardSourceById(outwardSid, outSource);
  	}

     //Outward Transaction Controller
    
    @Autowired
    OutwardTransService outwardTransServ;
    
    @Value("${bottlebuycost}")
	private int bottlebuycost;
   
   @Value("${capbuycost}")
  	private int capbuycost;
    
    
    @RequestMapping("/add/addOutwardTrans")
    public OutwardTrans addOutwardTrans(@RequestBody OutwardTrans outwardtrans)throws Exception {
 	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
 		outwardtrans.setOuttdate(dateWithoutTime);
 		int wbs=outwardtrans.getOutwardSid();//1
		int amt=outwardtrans.getOutamount();
		//int wb=
		//int bottleamt=20;
		//int capamt=10;
				
		//Product product =productService.getProductById(wbs);
		//int wb=product.getProductId();
	
		if(wbs==1) {
			
			Product p1=productService.getProductById(wbs);
			int qty=p1.getProductQty();
			
			int updateqnt=amt/bottlebuycost;
			if(qty>0)
			{
			qty=qty+updateqnt;
			System.out.println(qty);
			p1.setProductQty(qty);
			}
		}
		else if(wbs==2)
		{
			Product p1=productService.getProductById(wbs);
			int qty=p1.getProductQty();
			int updateqnt=amt/capbuycost;
			if(qty>0)
			{

			qty=qty+updateqnt;
			System.out.println(qty);
			p1.setProductQty(qty);
			}
			
		}
		else{
			System.out.println("other servicess..");
		}
		
 		
 	   return outwardTransServ.addOutwardTrans(outwardtrans);
    }
    
    @RequestMapping("/get/getOutTransBySourceid")
    public List<OutwardTrans> getOutTransBySourceid(@RequestParam("outwardSid")int outwardSid) {
 	   
 	   return outwardTransServ.getOutTransBySourceid(outwardSid);
    }
    
    @RequestMapping("/get/getAllOutwardTrans")
    public List<OutwardTrans> getAllOutwardTrans() {
 	   
 	   return outwardTransServ.getAllOutwardTrans();
    }
    
    @RequestMapping("/get/getByVoucherNo")
    public OutwardTrans getByVoucherNo(@RequestParam("voucherno")int voucherno) {
 	   
 	   return outwardTransServ.getByVoucherNo(voucherno);
    }
    
    @GetMapping("/get/getOutTransByDate")
    public List<OutwardTrans> getOutTransByDate(@RequestParam("outtdate") String tdate) throws Exception{

 	   return outwardTransServ.getOutTransByDate(tdate);
    }
    

    @GetMapping("/get/getFromToDateOuttrans")
    public List<OutwardTrans> getFromToDateOut(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate) throws Exception{

 	   return outwardTransServ.getFromToDateOut(fromtdate,totdate);
    }
    
    
    @GetMapping("/get/gettotalamtfromTodate")
    public int gettotalamtfromTodate(@RequestParam("fromtdate") String fromtdate,@RequestParam("totdate") String totdate) throws Exception{

 	   return outwardTransServ.gettotalamtfromTodate(fromtdate,totdate);
    }
    
    // Product
    
	
	
	@PostMapping("/add/insertProduct")
	public Product insertProduct(@RequestBody Product product) {
		
				return productService.insertProduct(product);
	}

	@DeleteMapping("/delete/deleteProductById")
	public String deleteProductById(@RequestParam("productId") int productId) {
		productService.deleteProductById(productId);
		return " Product Deleted Succesfully";
	}
	
	
	@RequestMapping("/get/getAllProduct")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	

	@GetMapping("/get/getProductById")
	public Product getProductById(@RequestParam("productId") int productId)
	{
		return productService.getProductById(productId);
	}
	
	@GetMapping("/get/getProductByName")
	public Product getProductByName(@RequestParam("productName") String productName)
	{
		return productService.getProductByName(productName);
	}
	
	
	@PutMapping("/update/updateProductById")
	public Product updateProductById(
			@RequestParam("productId") int productId,
			@RequestBody Product product)
	{
		return productService.updateProductById(productId, product);
	}
	
	
	@RequestMapping("/update/updatetest")
	public String updatetest()
	{
		return "updated successfully";
	}
	
	@RequestMapping("/add/addtest")
	public String addtest()
	{
		return "inserted successfully";
	}
	
	//defaulters
	
	
 	
	
	
	
	   
}


