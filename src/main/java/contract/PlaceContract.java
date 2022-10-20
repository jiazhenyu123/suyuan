package contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class PlaceContract extends Contract {
    public static final String BINARY = "608060405260028054905060035534801561001957600080fd5b506120d6806100296000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c806389ec5b061161006657806389ec5b0614610173578063954aae641461018f5780639e4c78f4146101ad578063aab01b18146101dd578063f2295615146101f95761009e565b80631f7b6d32146100a357806327ede887146100c1578063465c4105146100f15780634bba74d11461012157806374386a841461013f575b600080fd5b6100ab610215565b6040516100b891906112fd565b60405180910390f35b6100db60048036038101906100d69190611358565b61021b565b6040516100e8919061141e565b60405180910390f35b61010b60048036038101906101069190611575565b6102c7565b6040516101189190611608565b60405180910390f35b6101296103a4565b60405161013691906117c9565b60405180910390f35b610159600480360381019061015491906117eb565b610745565b60405161016a959493929190611834565b60405180910390f35b61018d60048036038101906101889190611358565b6109b1565b005b610197610a6b565b6040516101a4919061192e565b60405180910390f35b6101c760048036038101906101c291906117eb565b610cf1565b6040516101d49190611608565b60405180910390f35b6101f760048036038101906101f291906119ae565b610d27565b005b610213600480360381019061020e9190611b53565b611017565b005b60035481565b6002818154811061022b57600080fd5b90600052602060002001600091509050805461024690611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461027290611bcb565b80156102bf5780601f10610294576101008083540402835291602001916102bf565b820191906000526020600020905b8154815290600101906020018083116102a257829003601f168201915b505050505081565b600080839050600083905080518251146102e65760009250505061039e565b60005b82518110156103965781818151811061030557610304611bfd565b5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191683828151811061034557610344611bfd565b5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614610383576000935050505061039e565b808061038e90611c5b565b9150506102e9565b506001925050505b92915050565b6060600060035467ffffffffffffffff8111156103c4576103c361144a565b5b6040519080825280602002602001820160405280156103fd57816020015b6103ea611185565b8152602001906001900390816103e25790505b5090506000805b60035481101561073c5760016002828154811061042457610423611bfd565b5b9060005260206000200160405161043b9190611d43565b908152602001604051809103902060009054906101000a900460ff16156107235760006002828154811061047257610471611bfd565b5b906000526020600020016040516104899190611d43565b90815260200160405180910390206040518060a00160405290816000820180546104b290611bcb565b80601f01602080910402602001604051908101604052809291908181526020018280546104de90611bcb565b801561052b5780601f106105005761010080835404028352916020019161052b565b820191906000526020600020905b81548152906001019060200180831161050e57829003601f168201915b5050505050815260200160018201805461054490611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461057090611bcb565b80156105bd5780601f10610592576101008083540402835291602001916105bd565b820191906000526020600020905b8154815290600101906020018083116105a057829003601f168201915b505050505081526020016002820180546105d690611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461060290611bcb565b801561064f5780601f106106245761010080835404028352916020019161064f565b820191906000526020600020905b81548152906001019060200180831161063257829003601f168201915b5050505050815260200160038201805461066890611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461069490611bcb565b80156106e15780601f106106b6576101008083540402835291602001916106e1565b820191906000526020600020905b8154815290600101906020018083116106c457829003601f168201915b5050505050815260200160048201548152505083838061070090611c5b565b94508151811061071357610712611bfd565b5b6020026020010181905250610728565b610729565b5b808061073490611c5b565b915050610404565b50819250505090565b60008180516020810182018051848252602083016020850120818352809550505050505060009150905080600001805461077e90611bcb565b80601f01602080910402602001604051908101604052809291908181526020018280546107aa90611bcb565b80156107f75780601f106107cc576101008083540402835291602001916107f7565b820191906000526020600020905b8154815290600101906020018083116107da57829003601f168201915b50505050509080600101805461080c90611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461083890611bcb565b80156108855780601f1061085a57610100808354040283529160200191610885565b820191906000526020600020905b81548152906001019060200180831161086857829003601f168201915b50505050509080600201805461089a90611bcb565b80601f01602080910402602001604051908101604052809291908181526020018280546108c690611bcb565b80156109135780601f106108e857610100808354040283529160200191610913565b820191906000526020600020905b8154815290600101906020018083116108f657829003601f168201915b50505050509080600301805461092890611bcb565b80601f016020809104026020016040519081016040528092919081815260200182805461095490611bcb565b80156109a15780601f10610976576101008083540402835291602001916109a1565b820191906000526020600020905b81548152906001019060200180831161098457829003601f168201915b5050505050908060040154905085565b60035481106109bf57610a68565b60008190505b60016003546109d49190611d5a565b811015610a4e5760026001826109ea9190611d8e565b815481106109fb576109fa611bfd565b5b9060005260206000200160028281548110610a1957610a18611bfd565b5b90600052602060002001908054610a2f90611bcb565b610a3a9291906111b4565b508080610a4690611c5b565b9150506109c5565b5060036000815480929190610a6290611de4565b91905055505b50565b610a73611185565b6000604051610a8190611e5a565b90815260200160405180910390206040518060a0016040529081600082018054610aaa90611bcb565b80601f0160208091040260200160405190810160405280929190818152602001828054610ad690611bcb565b8015610b235780601f10610af857610100808354040283529160200191610b23565b820191906000526020600020905b815481529060010190602001808311610b0657829003601f168201915b50505050508152602001600182018054610b3c90611bcb565b80601f0160208091040260200160405190810160405280929190818152602001828054610b6890611bcb565b8015610bb55780601f10610b8a57610100808354040283529160200191610bb5565b820191906000526020600020905b815481529060010190602001808311610b9857829003601f168201915b50505050508152602001600282018054610bce90611bcb565b80601f0160208091040260200160405190810160405280929190818152602001828054610bfa90611bcb565b8015610c475780601f10610c1c57610100808354040283529160200191610c47565b820191906000526020600020905b815481529060010190602001808311610c2a57829003601f168201915b50505050508152602001600382018054610c6090611bcb565b80601f0160208091040260200160405190810160405280929190818152602001828054610c8c90611bcb565b8015610cd95780601f10610cae57610100808354040283529160200191610cd9565b820191906000526020600020905b815481529060010190602001808311610cbc57829003601f168201915b50505050508152602001600482015481525050905090565b6001818051602081018201805184825260208301602085012081835280955050505050506000915054906101000a900460ff1681565b8373ffffffffffffffffffffffffffffffffffffffff166367f58d19836040518263ffffffff1660e01b8152600401610d60919061141e565b602060405180830381865afa158015610d7d573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610da19190611e9b565b15610fdb578273ffffffffffffffffffffffffffffffffffffffff16637ce7f1b7826040518263ffffffff1660e01b8152600401610ddf919061141e565b602060405180830381865afa158015610dfc573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610e209190611e9b565b15610e5f577f14bd12cf13eb90f815a09f1000246c11764356a1825f1212d87798c1f4e741d8604051610e5290611f3a565b60405180910390a1611011565b6001600082604051610e719190611f8b565b9081526020016040518091039020600401819055506000600182604051610e989190611f8b565b908152602001604051809103902060006101000a81548160ff02191690831515021790555060005b600354811015610f9757610f7a60028281548110610ee157610ee0611bfd565b5b906000526020600020018054610ef690611bcb565b80601f0160208091040260200160405190810160405280929190818152602001828054610f2290611bcb565b8015610f6f5780601f10610f4457610100808354040283529160200191610f6f565b820191906000526020600020905b815481529060010190602001808311610f5257829003601f168201915b5050505050836102c7565b15610f8457610f97565b8080610f8f90611c5b565b915050610ec0565b610fa0816109b1565b7f14bd12cf13eb90f815a09f1000246c11764356a1825f1212d87798c1f4e741d8604051610fcd90611fee565b60405180910390a150611011565b7f14bd12cf13eb90f815a09f1000246c11764356a1825f1212d87798c1f4e741d860405161100890612080565b60405180910390a15b50505050565b6001816000015160405161102b9190611f8b565b908152602001604051809103902060009054906101000a900460ff166111825780600082600001516040516110609190611f8b565b9081526020016040518091039020600082015181600001908051906020019061108a929190611241565b5060208201518160010190805190602001906110a7929190611241565b5060408201518160020190805190602001906110c4929190611241565b5060608201518160030190805190602001906110e1929190611241565b506080820151816004015590505060018082600001516040516111049190611f8b565b908152602001604051809103902060006101000a81548160ff02191690831515021790555060028160000151908060018154018082558091505060019003906000526020600020016000909190919091509080519060200190611168929190611241565b506003600081548092919061117c90611c5b565b91905055505b50565b6040518060a0016040528060608152602001606081526020016060815260200160608152602001600081525090565b8280546111c090611bcb565b90600052602060002090601f0160209004810192826111e25760008555611230565b82601f106111f35780548555611230565b8280016001018555821561123057600052602060002091601f016020900482015b8281111561122f578254825591600101919060010190611214565b5b50905061123d91906112c7565b5090565b82805461124d90611bcb565b90600052602060002090601f01602090048101928261126f57600085556112b6565b82601f1061128857805160ff19168380011785556112b6565b828001600101855582156112b6579182015b828111156112b557825182559160200191906001019061129a565b5b5090506112c391906112c7565b5090565b5b808211156112e05760008160009055506001016112c8565b5090565b6000819050919050565b6112f7816112e4565b82525050565b600060208201905061131260008301846112ee565b92915050565b6000604051905090565b600080fd5b600080fd5b611335816112e4565b811461134057600080fd5b50565b6000813590506113528161132c565b92915050565b60006020828403121561136e5761136d611322565b5b600061137c84828501611343565b91505092915050565b600081519050919050565b600082825260208201905092915050565b60005b838110156113bf5780820151818401526020810190506113a4565b838111156113ce576000848401525b50505050565b6000601f19601f8301169050919050565b60006113f082611385565b6113fa8185611390565b935061140a8185602086016113a1565b611413816113d4565b840191505092915050565b6000602082019050818103600083015261143881846113e5565b905092915050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b611482826113d4565b810181811067ffffffffffffffff821117156114a1576114a061144a565b5b80604052505050565b60006114b4611318565b90506114c08282611479565b919050565b600067ffffffffffffffff8211156114e0576114df61144a565b5b6114e9826113d4565b9050602081019050919050565b82818337600083830152505050565b6000611518611513846114c5565b6114aa565b90508281526020810184848401111561153457611533611445565b5b61153f8482856114f6565b509392505050565b600082601f83011261155c5761155b611440565b5b813561156c848260208601611505565b91505092915050565b6000806040838503121561158c5761158b611322565b5b600083013567ffffffffffffffff8111156115aa576115a9611327565b5b6115b685828601611547565b925050602083013567ffffffffffffffff8111156115d7576115d6611327565b5b6115e385828601611547565b9150509250929050565b60008115159050919050565b611602816115ed565b82525050565b600060208201905061161d60008301846115f9565b92915050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b600082825260208201905092915050565b600061166b82611385565b611675818561164f565b93506116858185602086016113a1565b61168e816113d4565b840191505092915050565b6116a2816112e4565b82525050565b600060a08301600083015184820360008601526116c58282611660565b915050602083015184820360208601526116df8282611660565b915050604083015184820360408601526116f98282611660565b915050606083015184820360608601526117138282611660565b91505060808301516117286080860182611699565b508091505092915050565b600061173f83836116a8565b905092915050565b6000602082019050919050565b600061175f82611623565b611769818561162e565b93508360208202850161177b8561163f565b8060005b858110156117b757848403895281516117988582611733565b94506117a383611747565b925060208a0199505060018101905061177f565b50829750879550505050505092915050565b600060208201905081810360008301526117e38184611754565b905092915050565b60006020828403121561180157611800611322565b5b600082013567ffffffffffffffff81111561181f5761181e611327565b5b61182b84828501611547565b91505092915050565b600060a082019050818103600083015261184e81886113e5565b9050818103602083015261186281876113e5565b9050818103604083015261187681866113e5565b9050818103606083015261188a81856113e5565b905061189960808301846112ee565b9695505050505050565b600060a08301600083015184820360008601526118c08282611660565b915050602083015184820360208601526118da8282611660565b915050604083015184820360408601526118f48282611660565b9150506060830151848203606086015261190e8282611660565b91505060808301516119236080860182611699565b508091505092915050565b6000602082019050818103600083015261194881846118a3565b905092915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061197b82611950565b9050919050565b61198b81611970565b811461199657600080fd5b50565b6000813590506119a881611982565b92915050565b600080600080608085870312156119c8576119c7611322565b5b60006119d687828801611999565b94505060206119e787828801611999565b935050604085013567ffffffffffffffff811115611a0857611a07611327565b5b611a1487828801611547565b925050606085013567ffffffffffffffff811115611a3557611a34611327565b5b611a4187828801611547565b91505092959194509250565b600080fd5b600080fd5b600060a08284031215611a6d57611a6c611a4d565b5b611a7760a06114aa565b9050600082013567ffffffffffffffff811115611a9757611a96611a52565b5b611aa384828501611547565b600083015250602082013567ffffffffffffffff811115611ac757611ac6611a52565b5b611ad384828501611547565b602083015250604082013567ffffffffffffffff811115611af757611af6611a52565b5b611b0384828501611547565b604083015250606082013567ffffffffffffffff811115611b2757611b26611a52565b5b611b3384828501611547565b6060830152506080611b4784828501611343565b60808301525092915050565b600060208284031215611b6957611b68611322565b5b600082013567ffffffffffffffff811115611b8757611b86611327565b5b611b9384828501611a57565b91505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680611be357607f821691505b60208210811415611bf757611bf6611b9c565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611c66826112e4565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415611c9957611c98611c2c565b5b600182019050919050565b600081905092915050565b60008190508160005260206000209050919050565b60008154611cd181611bcb565b611cdb8186611ca4565b94506001821660008114611cf65760018114611d0757611d3a565b60ff19831686528186019350611d3a565b611d1085611caf565b60005b83811015611d3257815481890152600182019150602081019050611d13565b838801955050505b50505092915050565b6000611d4f8284611cc4565b915081905092915050565b6000611d65826112e4565b9150611d70836112e4565b925082821015611d8357611d82611c2c565b5b828203905092915050565b6000611d99826112e4565b9150611da4836112e4565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115611dd957611dd8611c2c565b5b828201905092915050565b6000611def826112e4565b91506000821415611e0357611e02611c2c565b5b600182039050919050565b7f3100000000000000000000000000000000000000000000000000000000000000600082015250565b6000611e44600183611ca4565b9150611e4f82611e0e565b600182019050919050565b6000611e6582611e37565b9150819050919050565b611e78816115ed565b8114611e8357600080fd5b50565b600081519050611e9581611e6f565b92915050565b600060208284031215611eb157611eb0611322565b5b6000611ebf84828501611e86565b91505092915050565b7f64656c65746520706c61636520627920706c6163654964206661696c65643a7460008201527f686520706c6163652068617320626f756e642074686520617373657421000000602082015250565b6000611f24603d83611390565b9150611f2f82611ec8565b604082019050919050565b60006020820190508181036000830152611f5381611f17565b9050919050565b6000611f6582611385565b611f6f8185611ca4565b9350611f7f8185602086016113a1565b80840191505092915050565b6000611f978284611f5a565b915081905092915050565b7f64656c65746520706c61636520627920706c6163654964207375636365737321600082015250565b6000611fd8602083611390565b9150611fe382611fa2565b602082019050919050565b6000602082019050818103600083015261200781611fcb565b9050919050565b7f64656c65746520706c61636520627920706c6163654964206661696c65643a7560008201527f7365727320726f6c652069736e277420656e6f75676821000000000000000000602082015250565b600061206a603783611390565b91506120758261200e565b604082019050919050565b600060208201905081810360008301526120998161205d565b905091905056fea26469706673582212207ec9377a7ce7bcf77272fcb17b866ea7c9443b56f799a808af498e30af6ea78c64736f6c634300080a0033";

    public static final String FUNC_CREATEPLACE = "createPlace";

    public static final String FUNC_DELETEPLACE = "deletePlace";

    public static final String FUNC_GETALLPLACELIST = "getAllPlaceList";

    public static final String FUNC_GETPLACEINFO = "getPlaceInfo";

    public static final String FUNC_ISEQUAL = "isEqual";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_PLACEINSERTED = "placeInserted";

    public static final String FUNC_PLACEKEY = "placeKey";

    public static final String FUNC_PLACES = "places";

    public static final String FUNC_REMOVEPLACEKEYATINDEX = "removePlaceKeyAtIndex";

    public static final Event DELETEMSG_EVENT = new Event("DeleteMsg",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected PlaceContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PlaceContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PlaceContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PlaceContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DeleteMsgEventResponse> getDeleteMsgEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DELETEMSG_EVENT, transactionReceipt);
        ArrayList<DeleteMsgEventResponse> responses = new ArrayList<DeleteMsgEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DeleteMsgEventResponse typedResponse = new DeleteMsgEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DeleteMsgEventResponse> deleteMsgEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DeleteMsgEventResponse>() {
            @Override
            public DeleteMsgEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEMSG_EVENT, log);
                DeleteMsgEventResponse typedResponse = new DeleteMsgEventResponse();
                typedResponse.log = log;
                typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DeleteMsgEventResponse> deleteMsgEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEMSG_EVENT));
        return deleteMsgEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createPlace(Place _place) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATEPLACE,
                Arrays.<Type>asList(_place),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deletePlace(String _userContract, String _placeAssetContract, String _account, String _placeId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETEPLACE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userContract),
                        new org.web3j.abi.datatypes.Address(160, _placeAssetContract),
                        new org.web3j.abi.datatypes.Utf8String(_account),
                        new org.web3j.abi.datatypes.Utf8String(_placeId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getAllPlaceList() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETALLPLACELIST,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Place>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Place> getPlaceInfo() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPLACEINFO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Place>() {}));
        return executeRemoteCallSingleValueReturn(function, Place.class);
    }

    public RemoteFunctionCall<Boolean> isEqual(String a, String b) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISEQUAL,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(a),
                        new org.web3j.abi.datatypes.Utf8String(b)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> placeInserted(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PLACEINSERTED,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> placeKey(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PLACEKEY,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple5<String, String, String, String, BigInteger>> places(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PLACES,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, String, String, BigInteger>>(function,
                new Callable<Tuple5<String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (String) results.get(3).getValue(),
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> removePlaceKeyAtIndex(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVEPLACEKEYATINDEX,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PlaceContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PlaceContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PlaceContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PlaceContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PlaceContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PlaceContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PlaceContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PlaceContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PlaceContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PlaceContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PlaceContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PlaceContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PlaceContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PlaceContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PlaceContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PlaceContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Place extends DynamicStruct {
        public String placeId;

        public String placeName;

        public String placeAddress;

        public String placeManagerAccount;

        public BigInteger status;

        public Place(String placeId, String placeName, String placeAddress, String placeManagerAccount, BigInteger status) {
            super(new org.web3j.abi.datatypes.Utf8String(placeId),new org.web3j.abi.datatypes.Utf8String(placeName),new org.web3j.abi.datatypes.Utf8String(placeAddress),new org.web3j.abi.datatypes.Utf8String(placeManagerAccount),new org.web3j.abi.datatypes.generated.Uint256(status));
            this.placeId = placeId;
            this.placeName = placeName;
            this.placeAddress = placeAddress;
            this.placeManagerAccount = placeManagerAccount;
            this.status = status;
        }

        public Place(Utf8String placeId, Utf8String placeName, Utf8String placeAddress, Utf8String placeManagerAccount, Uint256 status) {
            super(placeId,placeName,placeAddress,placeManagerAccount,status);
            this.placeId = placeId.getValue();
            this.placeName = placeName.getValue();
            this.placeAddress = placeAddress.getValue();
            this.placeManagerAccount = placeManagerAccount.getValue();
            this.status = status.getValue();
        }

        @Override
        public String toString() {
            return "Place{" +
                    "placeId='" + placeId + '\'' +
                    ", placeName='" + placeName + '\'' +
                    ", placeAddress='" + placeAddress + '\'' +
                    ", placeManagerAccount='" + placeManagerAccount + '\'' +
                    ", status=" + status +
                    '}';
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public String getPlaceAddress() {
            return placeAddress;
        }

        public void setPlaceAddress(String placeAddress) {
            this.placeAddress = placeAddress;
        }

        public String getPlaceManagerAccount() {
            return placeManagerAccount;
        }

        public void setPlaceManagerAccount(String placeManagerAccount) {
            this.placeManagerAccount = placeManagerAccount;
        }

        public BigInteger getStatus() {
            return status;
        }

        public void setStatus(BigInteger status) {
            this.status = status;
        }
    }

    public static class DeleteMsgEventResponse extends BaseEventResponse {
        public String data;
    }
}
