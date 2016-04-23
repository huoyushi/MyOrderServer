package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;
import com.huoyushi.util.BaseUtil;


@Aspect
@Component
public class SecAspect {
	private final String registCustomerPc="execution(* com.huoyushi.MyOrderServer.Service.UserManager.registerCustomer(..))";
	private final String registSellerPc="execution(* com.huoyushi.MyOrderServer.Service.UserManager.registerSeller(..))";
	private final String loginPc="execution(* com.huoyushi.MyOrderServer.Service.UserManager.login(..))";
	
	
	@Around(registSellerPc)
	public Object registSellerMdProcess(ProceedingJoinPoint jp){
		Object o=null;
		Seller seller=(Seller)jp.getArgs()[0];
		seller.setPsd(BaseUtil.JohnMd(seller.getPsd(), "md5"));
		try {
			o=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	@Around(loginPc)
	public Object loginMdProcess(ProceedingJoinPoint jp){
		Object o=null;
		String psd=(String)jp.getArgs()[1];
		
		try {
			o=jp.proceed(new Object[]{jp.getArgs()[0],BaseUtil.JohnMd(psd, "md5"),jp.getArgs()[2]});
		} catch (Throwable e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}
		return o;
				
	}
	@Around(registCustomerPc)
	public Object registCustomerMdProcess(ProceedingJoinPoint jp){
		Object o=null;
		Customer customer=(Customer)jp.getArgs()[0];
		System.out.println(customer.getPsd());
		customer.setPsd(BaseUtil.JohnMd(customer.getPsd(), "md5"));
		try {
			o=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
