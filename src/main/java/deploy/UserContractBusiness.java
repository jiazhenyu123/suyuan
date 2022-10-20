package deploy;

import constant.Data;
import contract.UserContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UserContractBusiness {
//    String address;
//
//    static Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//
//    static String pk = Data.PK;
//    static Credentials credentials = Credentials.create(pk);
//    static StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
//    static UserContract contract;
//
//    static {
//        try {
//            contract = UserContract.deploy(web3j,credentials,provider).send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    ;
//
//    static {
//        try {
//            contract = UserContract.deploy(web3j,credentials,provider).send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));
//        web3j.
        String pk = Data.PK;
        Credentials credentials = Credentials.create(pk);
        StaticGasProvider provider = new StaticGasProvider(new BigInteger("20000000000"),new BigInteger("6721975"));
        System.out.println("——————————————————部署UserContract智能合约——————————————————————");
        UserContract userContract;

//        userContract = UserContract.deploy(web3j,credentials,provider).send();
        userContract = UserContract.load("0xce3f1717d5ca693ca51a1c0c8ee148362de7e668",web3j,credentials,provider);
        // 部署完成后打印合约地址
        System.out.println("ContractAddress:" + userContract.getContractAddress());
        // 判断部署的合约是否可用
        System.out.println("isValid:" + userContract.isValid());
        if(userContract.isValid()){

            // admin用户
            UserContract.User user = new UserContract.User(
                    "admin",
                    "admin",
                    "15906888912",
                    "827ccb0eea8a706c4c34a16891f84e7b",
                    new BigInteger("1"),
                    new BigInteger("2"),
                    new BigInteger("0")
            );

            // pwd 12345
            UserContract.User jzy = new UserContract.User(
                    "19052238",
                    "jzy",
                    "15906888912",
                    "827ccb0eea8a706c4c34a16891f84e7b",
                    new BigInteger("1"),
                    new BigInteger("0"),
                    new BigInteger("0")
            );

            // pwd 12345
            UserContract.User lyl = new UserContract.User(
                    "19052239",
                    "lyl",
                    "18106660269",
                    "827ccb0eea8a706c4c34a16891f84e7b",
                    new BigInteger("1"),
                    new BigInteger("0"),
                    new BigInteger("0")
            );

            // pwd 12345
            UserContract.User cyb = new UserContract.User(
                    "19052240",
                    "cyb",
                    "15906888912",
                    "827ccb0eea8a706c4c34a16891f84e7b",
                    new BigInteger("1"),
                    new BigInteger("0"),
                    new BigInteger("0")
            );
//            // pwd 12345
//            UserContract.User aaa = new UserContract.User(
//                    "19052241",
//                    "aaa",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//            // pwd 12345
//            UserContract.User bbb = new UserContract.User(
//                    "19052242",
//                    "bbb",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//            // pwd 12345
//            UserContract.User ccc = new UserContract.User(
//                    "19052243",
//                    "ccc",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//            // pwd 12345
//            UserContract.User ddd = new UserContract.User(
//                    "19052244",
//                    "ddd",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//
//            // pwd 12345
//            UserContract.User eee = new UserContract.User(
//                    "19052245",
//                    "eee",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//
//            // pwd 12345
//            UserContract.User fff = new UserContract.User(
//                    "19052246",
//                    "fff",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//
//            // pwd 12345
//            UserContract.User ggg = new UserContract.User(
//                    "19052247",
//                    "ggg",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );
//
//            // pwd 12345
//            UserContract.User hhh = new UserContract.User(
//                    "19052248",
//                    "hhh",
//                    "15906888912",
//                    "827ccb0eea8a706c4c34a16891f84e7b",
//                    new BigInteger("1"),
//                    new BigInteger("0"),
//                    new BigInteger("0")
//            );



            List<UserContract.User> list = new ArrayList<>();
            list.add(user);
            list.add(cyb);
            list.add(jzy);
            list.add(lyl);

//            list.add(aaa);
//            list.add(bbb);
//            list.add(ccc);
//
//            list.add(ddd);
//            list.add(eee);
//            list.add(fff);
//
//            list.add(ggg);
//            list.add(hhh);
            userContract.batchAddUser(list).sendAsync().get();

            List<UserContract.User> userList = userContract.getUserList(new BigInteger("0")).sendAsync().get();
            System.out.println(userList.size());
            for (UserContract.User u : userList) {
                System.out.println(u.account);
            }

//            //
//            BigInteger userId,infoId,role;
//            String account,name,salt,phone,password;
//            userId = new BigInteger("0");
//            infoId = new BigInteger("0");
//            role = new BigInteger("0");
//            account = "19052238";
//            name = "贾振宇";
//            salt = "salt";
//            phone = "19858104807";
//            password = "12345";
//            TransactionReceipt receipt = contract.setUser(account,name,salt,phone,password,role).sendAsync().get();
//            List<UserContract.User> user = new ArrayList<>();
//            UserContract.User user1 = new UserContract.User("19052240","lyl","198xxxxxxx","12345","salt",new BigInteger("1"),new BigInteger("0"));
//            user.add(user1);
//            user1 = new UserContract.User("19052241","cyb","198xxxxxxx","12345","salt",new BigInteger("1"),new BigInteger("0"));
//            user.add(user1);
//            contract.batchAddUser(user).send();
//
//            List<UserContract.User> list = contract.getRoleList().sendAsync().get();
//            System.out.println(list.toArray().toString());

//            System.out.println(receipt);
//            Tuple7<String,String,String,String,String,BigInteger,BigInteger> tuple =  contract.users("19052238").send();
//            System.out.println(tuple.component1() + " " + tuple.component2() + " " + tuple.component3() + " " + tuple.component4());
//
//
//            receipt = contract.modifyPasswordByAccount(account,"54321").send();
//            System.out.println(receipt.getLogs().size());
//            tuple =  contract.users("19052238").send();
//            System.out.println(tuple.component1() + " " + tuple.component2() + " " + tuple.component3() + " " + tuple.component4());
//            contract.modifyPasswordByAccount();
//            if(contract.userInserted("0").send()){
//                receipt = contract.modifyPasswordByAccount(account,password).send();
//            }else{
//                System.out.println("modifyPhone,the user isn't exist!");
//            }
//            receipt = contract.modifyPhoneByAccount("19052238","54321").sendAsync().get();
            //测试修改密码
//            receipt = contract.modifyPasswordByAccount(account,"54321").send();
//            List<UserContract.LogEventResponse> eventValues = contract.getLogEvents(receipt);
//            System.out.println("message:" + eventValues.get(0).message + "," + "value:" + eventValues.get(0).value);
//            //测试修改电话
//            receipt = contract.modifyPhoneByAccount(account,"1234567").send();
//            eventValues = contract.getLogEvents(receipt);
//            System.out.println("message:" + eventValues.get(0).message + "," + "value:" + eventValues.get(0).value);


//             UserContract.User user = contract.getUserInfo("19052238").send();
//            List<UserContract.ReturnUserInfoEventResponse> returnUserInfo = contract.getReturnUserInfoEvents(receipt);
//            for (int i = 0;i < returnUserInfo.size();i++){
//                System.out.println(returnUserInfo.get(i).message + "," + returnUserInfo.get(i).user);
//            }



//            receipt = contract.getUserInfo("0").send();
//            returnUserInfo = contract.getReturnUserInfoEvents(receipt);
//            eventValues = contract.getLogEvents(receipt);
//            for (int i = 0;i < returnUserInfo.size();i++){
//                System.out.println(returnUserInfo.get(i).message + "," + returnUserInfo.get(i).user);
//            }

            //UserContract.User user = new UserContract.User()

        }

    }


//    public String modifyPasswordByAccount(String account,String password) throws Exception {
//        if(contract.isValid()){
//            if(contract.userInserted(account).send()){
//                TransactionReceipt receipt = contract.modifyPasswordByAccount(account,password).send();
//                return "10000";
//            }
//        }
//        return "10001";
//    }
//
//    public String setUser(String userId, String infoId, String account, String name, String salt, String phone, String password, String role) throws Exception {
//        if(contract.isValid()) {
//            if (!contract.userInserted(account).send()) {
//                TransactionReceipt receipt = contract.setUser(account, name, salt, phone, password, new BigInteger(role)).send();
//                return "10000";
//            }
//        }
//        return "10001";
//    }
//
//    public String modifyPhoneByAccount(String account,String phone) throws Exception {
//        if(contract.isValid()){
//            if(contract.userInserted(account).send()){
//                TransactionReceipt receipt = contract.modifyPhoneByAccount(account,phone).send();
//                return "10000";
//            }
//        }
//        return "10001";
//    }


}
