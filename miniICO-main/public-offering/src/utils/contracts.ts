import Funding from './Funding.json'
import web3 from './web3'

// 修改地址为合约所在区块内的地址
var contractAddr = "0xe1B7Cf33350628E6E176359F6a92A16F36f98524"
const FundingABI = Funding.abi

// 获取合约实例
// @ts-ignore
const contract = new web3.eth.Contract(FundingABI, contractAddr);

export default contract
