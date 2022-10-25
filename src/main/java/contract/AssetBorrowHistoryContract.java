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
import org.web3j.tuples.generated.Tuple11;
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
public class AssetBorrowHistoryContract extends Contract {
    public static final String BINARY = "608060405260028054905060035534801561001957600080fd5b50611c17806100296000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063089e3c491461006757806351c494aa14610083578063989425c1146100b3578063a32a3e7a146100e3578063cb6e2fa1146100ff578063ee2595d31461012f575b600080fd5b610081600480360381019061007c91906115c5565b610169565b005b61009d6004803603810190610098919061160e565b61035a565b6040516100aa9190611672565b60405180910390f35b6100cd60048036038101906100c8919061168d565b610390565b6040516100da9190611742565b60405180910390f35b6100fd60048036038101906100f891906115c5565b61043c565b005b6101196004803603810190610114919061160e565b610648565b60405161012691906118e4565b60405180910390f35b6101496004803603810190610144919061160e565b610bee565b6040516101609b9a99989796959493929190611915565b60405180910390f35b6001816000015160405161017d9190611a3b565b908152602001604051809103902060009054906101000a900460ff161561031d5780600082600001516040516101b39190611a3b565b908152602001604051809103902060008201518160000190805190602001906101dd929190611126565b5060208201518160010190805190602001906101fa929190611126565b506040820151816002019080519060200190610217929190611126565b506060820151816003019080519060200190610234929190611126565b506080820151816004019080519060200190610251929190611126565b5060a082015181600501908051906020019061026e929190611126565b5060c082015181600601908051906020019061028b929190611126565b5060e082015181600701556101008201518160080190805190602001906102b3929190611126565b506101208201518160090190805190602001906102d1929190611126565b5061014082015181600a01559050507f1f0b7755550dd48676926d868a91257934b9a64d5f852cad45e85274c052c6b060c86040516103109190611a97565b60405180910390a1610357565b7f1f0b7755550dd48676926d868a91257934b9a64d5f852cad45e85274c052c6b061271160405161034e9190611aed565b60405180910390a15b50565b6001818051602081018201805184825260208301602085012081835280955050505050506000915054906101000a900460ff1681565b600281815481106103a057600080fd5b9060005260206000200160009150905080546103bb90611b37565b80601f01602080910402602001604051908101604052809291908181526020018280546103e790611b37565b80156104345780601f1061040957610100808354040283529160200191610434565b820191906000526020600020905b81548152906001019060200180831161041757829003601f168201915b505050505081565b600181600001516040516104509190611a3b565b908152602001604051809103902060009054906101000a900460ff166106455780600082600001516040516104859190611a3b565b908152602001604051809103902060008201518160000190805190602001906104af929190611126565b5060208201518160010190805190602001906104cc929190611126565b5060408201518160020190805190602001906104e9929190611126565b506060820151816003019080519060200190610506929190611126565b506080820151816004019080519060200190610523929190611126565b5060a0820151816005019080519060200190610540929190611126565b5060c082015181600601908051906020019061055d929190611126565b5060e08201518160070155610100820151816008019080519060200190610585929190611126565b506101208201518160090190805190602001906105a3929190611126565b5061014082015181600a015590505060018082600001516040516105c79190611a3b565b908152602001604051809103902060006101000a81548160ff0219169083151502179055506002816000015190806001815401808255809150506001900390600052602060002001600090919091909150908051906020019061062b929190611126565b506003600081548092919061063f90611b98565b91905055505b50565b6106506111ac565b6001826040516106609190611a3b565b908152602001604051809103902060009054906101000a900460ff1615610be8576000826040516106919190611a3b565b9081526020016040518091039020604051806101600160405290816000820180546106bb90611b37565b80601f01602080910402602001604051908101604052809291908181526020018280546106e790611b37565b80156107345780601f1061070957610100808354040283529160200191610734565b820191906000526020600020905b81548152906001019060200180831161071757829003601f168201915b5050505050815260200160018201805461074d90611b37565b80601f016020809104026020016040519081016040528092919081815260200182805461077990611b37565b80156107c65780601f1061079b576101008083540402835291602001916107c6565b820191906000526020600020905b8154815290600101906020018083116107a957829003601f168201915b505050505081526020016002820180546107df90611b37565b80601f016020809104026020016040519081016040528092919081815260200182805461080b90611b37565b80156108585780601f1061082d57610100808354040283529160200191610858565b820191906000526020600020905b81548152906001019060200180831161083b57829003601f168201915b5050505050815260200160038201805461087190611b37565b80601f016020809104026020016040519081016040528092919081815260200182805461089d90611b37565b80156108ea5780601f106108bf576101008083540402835291602001916108ea565b820191906000526020600020905b8154815290600101906020018083116108cd57829003601f168201915b5050505050815260200160048201805461090390611b37565b80601f016020809104026020016040519081016040528092919081815260200182805461092f90611b37565b801561097c5780601f106109515761010080835404028352916020019161097c565b820191906000526020600020905b81548152906001019060200180831161095f57829003601f168201915b5050505050815260200160058201805461099590611b37565b80601f01602080910402602001604051908101604052809291908181526020018280546109c190611b37565b8015610a0e5780601f106109e357610100808354040283529160200191610a0e565b820191906000526020600020905b8154815290600101906020018083116109f157829003601f168201915b50505050508152602001600682018054610a2790611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610a5390611b37565b8015610aa05780601f10610a7557610100808354040283529160200191610aa0565b820191906000526020600020905b815481529060010190602001808311610a8357829003601f168201915b5050505050815260200160078201548152602001600882018054610ac390611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610aef90611b37565b8015610b3c5780601f10610b1157610100808354040283529160200191610b3c565b820191906000526020600020905b815481529060010190602001808311610b1f57829003601f168201915b50505050508152602001600982018054610b5590611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610b8190611b37565b8015610bce5780601f10610ba357610100808354040283529160200191610bce565b820191906000526020600020905b815481529060010190602001808311610bb157829003601f168201915b50505050508152602001600a820154815250509050610be9565b5b919050565b600081805160208101820180518482526020830160208501208183528095505050505050600091509050806000018054610c2790611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610c5390611b37565b8015610ca05780601f10610c7557610100808354040283529160200191610ca0565b820191906000526020600020905b815481529060010190602001808311610c8357829003601f168201915b505050505090806001018054610cb590611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610ce190611b37565b8015610d2e5780601f10610d0357610100808354040283529160200191610d2e565b820191906000526020600020905b815481529060010190602001808311610d1157829003601f168201915b505050505090806002018054610d4390611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610d6f90611b37565b8015610dbc5780601f10610d9157610100808354040283529160200191610dbc565b820191906000526020600020905b815481529060010190602001808311610d9f57829003601f168201915b505050505090806003018054610dd190611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610dfd90611b37565b8015610e4a5780601f10610e1f57610100808354040283529160200191610e4a565b820191906000526020600020905b815481529060010190602001808311610e2d57829003601f168201915b505050505090806004018054610e5f90611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610e8b90611b37565b8015610ed85780601f10610ead57610100808354040283529160200191610ed8565b820191906000526020600020905b815481529060010190602001808311610ebb57829003601f168201915b505050505090806005018054610eed90611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610f1990611b37565b8015610f665780601f10610f3b57610100808354040283529160200191610f66565b820191906000526020600020905b815481529060010190602001808311610f4957829003601f168201915b505050505090806006018054610f7b90611b37565b80601f0160208091040260200160405190810160405280929190818152602001828054610fa790611b37565b8015610ff45780601f10610fc957610100808354040283529160200191610ff4565b820191906000526020600020905b815481529060010190602001808311610fd757829003601f168201915b50505050509080600701549080600801805461100f90611b37565b80601f016020809104026020016040519081016040528092919081815260200182805461103b90611b37565b80156110885780601f1061105d57610100808354040283529160200191611088565b820191906000526020600020905b81548152906001019060200180831161106b57829003601f168201915b50505050509080600901805461109d90611b37565b80601f01602080910402602001604051908101604052809291908181526020018280546110c990611b37565b80156111165780601f106110eb57610100808354040283529160200191611116565b820191906000526020600020905b8154815290600101906020018083116110f957829003601f168201915b50505050509080600a015490508b565b82805461113290611b37565b90600052602060002090601f016020900481019282611154576000855561119b565b82601f1061116d57805160ff191683800117855561119b565b8280016001018555821561119b579182015b8281111561119a57825182559160200191906001019061117f565b5b5090506111a89190611206565b5090565b60405180610160016040528060608152602001606081526020016060815260200160608152602001606081526020016060815260200160608152602001600081526020016060815260200160608152602001600081525090565b5b8082111561121f576000816000905550600101611207565b5090565b6000604051905090565b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6112858261123c565b810181811067ffffffffffffffff821117156112a4576112a361124d565b5b80604052505050565b60006112b7611223565b90506112c3828261127c565b919050565b600080fd5b600080fd5b600080fd5b600067ffffffffffffffff8211156112f2576112f161124d565b5b6112fb8261123c565b9050602081019050919050565b82818337600083830152505050565b600061132a611325846112d7565b6112ad565b905082815260208101848484011115611346576113456112d2565b5b611351848285611308565b509392505050565b600082601f83011261136e5761136d6112cd565b5b813561137e848260208601611317565b91505092915050565b6000819050919050565b61139a81611387565b81146113a557600080fd5b50565b6000813590506113b781611391565b92915050565b600061016082840312156113d4576113d3611237565b5b6113df6101606112ad565b9050600082013567ffffffffffffffff8111156113ff576113fe6112c8565b5b61140b84828501611359565b600083015250602082013567ffffffffffffffff81111561142f5761142e6112c8565b5b61143b84828501611359565b602083015250604082013567ffffffffffffffff81111561145f5761145e6112c8565b5b61146b84828501611359565b604083015250606082013567ffffffffffffffff81111561148f5761148e6112c8565b5b61149b84828501611359565b606083015250608082013567ffffffffffffffff8111156114bf576114be6112c8565b5b6114cb84828501611359565b60808301525060a082013567ffffffffffffffff8111156114ef576114ee6112c8565b5b6114fb84828501611359565b60a08301525060c082013567ffffffffffffffff81111561151f5761151e6112c8565b5b61152b84828501611359565b60c08301525060e061153f848285016113a8565b60e08301525061010082013567ffffffffffffffff811115611564576115636112c8565b5b61157084828501611359565b6101008301525061012082013567ffffffffffffffff811115611596576115956112c8565b5b6115a284828501611359565b610120830152506101406115b8848285016113a8565b6101408301525092915050565b6000602082840312156115db576115da61122d565b5b600082013567ffffffffffffffff8111156115f9576115f8611232565b5b611605848285016113bd565b91505092915050565b6000602082840312156116245761162361122d565b5b600082013567ffffffffffffffff81111561164257611641611232565b5b61164e84828501611359565b91505092915050565b60008115159050919050565b61166c81611657565b82525050565b60006020820190506116876000830184611663565b92915050565b6000602082840312156116a3576116a261122d565b5b60006116b1848285016113a8565b91505092915050565b600081519050919050565b600082825260208201905092915050565b60005b838110156116f45780820151818401526020810190506116d9565b83811115611703576000848401525b50505050565b6000611714826116ba565b61171e81856116c5565b935061172e8185602086016116d6565b6117378161123c565b840191505092915050565b6000602082019050818103600083015261175c8184611709565b905092915050565b600082825260208201905092915050565b6000611780826116ba565b61178a8185611764565b935061179a8185602086016116d6565b6117a38161123c565b840191505092915050565b6117b781611387565b82525050565b60006101608301600083015184820360008601526117db8282611775565b915050602083015184820360208601526117f58282611775565b9150506040830151848203604086015261180f8282611775565b915050606083015184820360608601526118298282611775565b915050608083015184820360808601526118438282611775565b91505060a083015184820360a086015261185d8282611775565b91505060c083015184820360c08601526118778282611775565b91505060e083015161188c60e08601826117ae565b506101008301518482036101008601526118a68282611775565b9150506101208301518482036101208601526118c28282611775565b9150506101408301516118d96101408601826117ae565b508091505092915050565b600060208201905081810360008301526118fe81846117bd565b905092915050565b61190f81611387565b82525050565b6000610160820190508181036000830152611930818e611709565b90508181036020830152611944818d611709565b90508181036040830152611958818c611709565b9050818103606083015261196c818b611709565b90508181036080830152611980818a611709565b905081810360a08301526119948189611709565b905081810360c08301526119a88188611709565b90506119b760e0830187611906565b8181036101008301526119ca8186611709565b90508181036101208301526119df8185611709565b90506119ef610140830184611906565b9c9b505050505050505050505050565b600081905092915050565b6000611a15826116ba565b611a1f81856119ff565b9350611a2f8185602086016116d6565b80840191505092915050565b6000611a478284611a0a565b915081905092915050565b6000819050919050565b6000819050919050565b6000611a81611a7c611a7784611a52565b611a5c565b611387565b9050919050565b611a9181611a66565b82525050565b6000602082019050611aac6000830184611a88565b92915050565b6000819050919050565b6000611ad7611ad2611acd84611ab2565b611a5c565b611387565b9050919050565b611ae781611abc565b82525050565b6000602082019050611b026000830184611ade565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680611b4f57607f821691505b60208210811415611b6357611b62611b08565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611ba382611387565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415611bd657611bd5611b69565b5b60018201905091905056fea26469706673582212204c17b56970658474aa24620e7e36aea3baebc557b101d20aacd66e9ca82d125b64736f6c634300080a0033";

    public static final String FUNC_ASSETBHINSERTED = "assetBHInserted";

    public static final String FUNC_ASSETBHKEY = "assetBHKey";

    public static final String FUNC_ASSETBHS = "assetBHs";

    public static final String FUNC_GETASSETBHBYASSETBORROWAPPLYID = "getAssetBHByAssetBorrowApplyId";

    public static final String FUNC_INSERTASSERTBORROWHISTORY = "insertAssertBorrowHistory";

    public static final String FUNC_UPDATE = "update";

    public static final Event ISUPDATESUCCESS_EVENT = new Event("isUpdateSuccess",
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected AssetBorrowHistoryContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AssetBorrowHistoryContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AssetBorrowHistoryContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AssetBorrowHistoryContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<IsUpdateSuccessEventResponse> getIsUpdateSuccessEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ISUPDATESUCCESS_EVENT, transactionReceipt);
        ArrayList<IsUpdateSuccessEventResponse> responses = new ArrayList<IsUpdateSuccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IsUpdateSuccessEventResponse typedResponse = new IsUpdateSuccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<IsUpdateSuccessEventResponse> isUpdateSuccessEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, IsUpdateSuccessEventResponse>() {
            @Override
            public IsUpdateSuccessEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ISUPDATESUCCESS_EVENT, log);
                IsUpdateSuccessEventResponse typedResponse = new IsUpdateSuccessEventResponse();
                typedResponse.log = log;
                typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<IsUpdateSuccessEventResponse> isUpdateSuccessEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ISUPDATESUCCESS_EVENT));
        return isUpdateSuccessEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> assetBHInserted(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ASSETBHINSERTED,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> assetBHKey(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ASSETBHKEY,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple11<String, String, String, String, String, String, String, BigInteger, String, String, BigInteger>> assetBHs(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ASSETBHS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple11<String, String, String, String, String, String, String, BigInteger, String, String, BigInteger>>(function,
                new Callable<Tuple11<String, String, String, String, String, String, String, BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple11<String, String, String, String, String, String, String, BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple11<String, String, String, String, String, String, String, BigInteger, String, String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (String) results.get(3).getValue(),
                                (String) results.get(4).getValue(),
                                (String) results.get(5).getValue(),
                                (String) results.get(6).getValue(),
                                (BigInteger) results.get(7).getValue(),
                                (String) results.get(8).getValue(),
                                (String) results.get(9).getValue(),
                                (BigInteger) results.get(10).getValue());
                    }
                });
    }

    public RemoteFunctionCall<AssetBorrowHistory> getAssetBHByAssetBorrowApplyId(String _assetBorrowApplyId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETASSETBHBYASSETBORROWAPPLYID,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_assetBorrowApplyId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<AssetBorrowHistory>() {}));
        return executeRemoteCallSingleValueReturn(function, AssetBorrowHistory.class);
    }

    public RemoteFunctionCall<TransactionReceipt> insertAssertBorrowHistory(AssetBorrowHistory _assetBorrowHistory) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INSERTASSERTBORROWHISTORY,
                Arrays.<Type>asList(_assetBorrowHistory),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> update(AssetBorrowHistory _assetBorrowHistory) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(_assetBorrowHistory),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AssetBorrowHistoryContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssetBorrowHistoryContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AssetBorrowHistoryContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssetBorrowHistoryContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AssetBorrowHistoryContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AssetBorrowHistoryContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AssetBorrowHistoryContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AssetBorrowHistoryContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AssetBorrowHistoryContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssetBorrowHistoryContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssetBorrowHistoryContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssetBorrowHistoryContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AssetBorrowHistoryContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssetBorrowHistoryContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssetBorrowHistoryContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssetBorrowHistoryContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AssetBorrowHistory extends DynamicStruct {
        public String assetBorrowApplyId;

        public String placeAssetId;

        public String borrowerAccount;

        public String reviewerAccount;

        public String beginTime;

        public String endTime;

        public String borrowReason;

        public BigInteger reviewStatus;

        public String reviewReason;

        public String reiviewTime;

        public BigInteger currentStatus;

        public AssetBorrowHistory(String assetBorrowApplyId, String placeAssetId, String borrowerAccount, String reviewerAccount, String beginTime, String endTime, String borrowReason, BigInteger reviewStatus, String reviewReason, String reiviewTime, BigInteger currentStatus) {
            super(new org.web3j.abi.datatypes.Utf8String(assetBorrowApplyId),new org.web3j.abi.datatypes.Utf8String(placeAssetId),new org.web3j.abi.datatypes.Utf8String(borrowerAccount),new org.web3j.abi.datatypes.Utf8String(reviewerAccount),new org.web3j.abi.datatypes.Utf8String(beginTime),new org.web3j.abi.datatypes.Utf8String(endTime),new org.web3j.abi.datatypes.Utf8String(borrowReason),new org.web3j.abi.datatypes.generated.Uint256(reviewStatus),new org.web3j.abi.datatypes.Utf8String(reviewReason),new org.web3j.abi.datatypes.Utf8String(reiviewTime),new org.web3j.abi.datatypes.generated.Uint256(currentStatus));
            this.assetBorrowApplyId = assetBorrowApplyId;
            this.placeAssetId = placeAssetId;
            this.borrowerAccount = borrowerAccount;
            this.reviewerAccount = reviewerAccount;
            this.beginTime = beginTime;
            this.endTime = endTime;
            this.borrowReason = borrowReason;
            this.reviewStatus = reviewStatus;
            this.reviewReason = reviewReason;
            this.reiviewTime = reiviewTime;
            this.currentStatus = currentStatus;
        }

        public AssetBorrowHistory(Utf8String assetBorrowApplyId, Utf8String placeAssetId, Utf8String borrowerAccount, Utf8String reviewerAccount, Utf8String beginTime, Utf8String endTime, Utf8String borrowReason, Uint256 reviewStatus, Utf8String reviewReason, Utf8String reiviewTime, Uint256 currentStatus) {
            super(assetBorrowApplyId,placeAssetId,borrowerAccount,reviewerAccount,beginTime,endTime,borrowReason,reviewStatus,reviewReason,reiviewTime,currentStatus);
            this.assetBorrowApplyId = assetBorrowApplyId.getValue();
            this.placeAssetId = placeAssetId.getValue();
            this.borrowerAccount = borrowerAccount.getValue();
            this.reviewerAccount = reviewerAccount.getValue();
            this.beginTime = beginTime.getValue();
            this.endTime = endTime.getValue();
            this.borrowReason = borrowReason.getValue();
            this.reviewStatus = reviewStatus.getValue();
            this.reviewReason = reviewReason.getValue();
            this.reiviewTime = reiviewTime.getValue();
            this.currentStatus = currentStatus.getValue();
        }
    }

    public static class IsUpdateSuccessEventResponse extends BaseEventResponse {
        public BigInteger code;
    }
}
