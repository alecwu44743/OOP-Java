public class VendingMachineAPP{
    public static void main(String[] args){
        int cnt = 10;
        while(cnt > 0){
            VendingMachine vm = new VendingMachine();
            vm.run();

            cnt--;
            
        }
    }
}