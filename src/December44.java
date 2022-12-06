import java.util.HashMap;
import java.util.Map;

public class December44 {
    public static Map<String, String> countries = new HashMap<>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDateAdapter implements Customer, Contact{
        private IncomeDate incomeDate;
        public IncomeDateAdapter(IncomeDate incomeDate){
            this.incomeDate = incomeDate;
        }

        @Override
        public String getName() {
            return incomeDate.getContactLastName()+", "+incomeDate.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String m = String.format("+%d(%2$s)%3$s-%4$s-%5$s", incomeDate.getCountryPhoneCode(),
            String.format("%010d", incomeDate.getPhoneNumber()).substring(0,3),
            String.format("%010d", incomeDate.getPhoneNumber()).substring(3,6),
            String.format("%010d", incomeDate.getPhoneNumber()).substring(6,8),
            String.format("%010d", incomeDate.getPhoneNumber()).substring(8));
            return m;
        }

        @Override
        public String getCompanyName() {
            return incomeDate.getCompany();
        }

        @Override
        public String getCountyName() {
            return countries.get(incomeDate.getCountyCode());
        }
    }
}
