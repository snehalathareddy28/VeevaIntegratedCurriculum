import org.testng.annotations.Test;

public class TestngGroups {
    @Test(groups  = {"smoke"})
    void titleCheck(){
        System.out.println("Title check");
    }

    @Test(groups = {"login","smoke"})
        void validLogin(){
            System.out.println("Valid login");
        }

    @Test(groups = {"login","regression"})
            void invalidLogin() {
                System.out.println("Invalid login");
            }
    @Test(enabled = false)
         void dashboardCheck(){
        System.out.println("Dashboard check");
    }
        }

