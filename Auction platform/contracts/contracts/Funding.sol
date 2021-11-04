// SPDX-License-Identifier: SimPL-2.0
pragma solidity >=0.4.22 <0.9.0;
pragma experimental ABIEncoderV2;
//import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
contract Funding {
   
    // 使用请求信息
    struct Use {
        string useDescription;              // 使用说明
        uint   amount;                      // 请求使用的金额
        uint   agreeAmount;                 // 同意的钱，以太坊不太好进行浮点数计算，所以用整形进行表示
        uint   disagreeAmount;              // 不同意的钱，以太坊不太好进行浮点数计算，所以用整形进行表示
        uint   numVote;                     // 投票数量
        uint[] agree;                       // 从用户序号到是否同意的状态映射
        // 0 没投过票
        // 1 投票同意
        // 2 投票不同意
    }

    // 项目信息
    struct Campaign {
        // 构造函数填充
        string projectName;                 // 项目名
        string projectDescription;          // 项目描述
        address payable manager;            // 发起者
        address payable lastmanager;
        uint targetMoney;                   // 目标筹集金额
        uint durTime;                       // 项目结束时间，单位天

        uint startTime;                     // 项目开始时间
        uint endTime;                       // 项目结束时间
        uint collectedMoney;                // 收集到的金额
        uint numFunders;                    // 参与成员的数量
        // uint privatee;                      //建立的该NFT是否进行拍卖,1表示不进行拍卖，0表示进行拍卖
        uint state;                         /**
                                             * 给合约建立一个状态机：
                                             * 0：还未进行任何买卖
                                             * 1：正在进行买卖，有人出价
                                             * 2：合约成功（募集成功而且使用成功）
                                             * 3：合约在规定时间内募集成功，还没发起使用
                                             * 4：发起了使用请求，正在接受请求
                                             */

        address payable[] funders;                  // 参与成员的地址
        uint[]    amount;                   // 参与者贡献的金额
    }

    uint public numCampaigns;                      // 众筹项目的数量
    mapping (uint => Campaign) public campaigns;   // 众筹项目的信息
    mapping (uint => Use) public uses;             // 因为结构体内嵌不能成功编译，所以将Use单独拿出来

    //铸造新的nft
    function newCampaign(string memory name, string memory desc, address payable manager, uint target, uint dur) public
    returns (uint) {
        require(dur > 0);
        // campaignID 作为一个变量返回
        uint campaignID = numCampaigns++;

        address payable[] memory funders;
        uint[] memory amount;
        Campaign memory c = Campaign({
        projectName: name,
        projectDescription: desc,
        manager: manager,
        lastmanager: manager,
        targetMoney: target * 1 ether,
        durTime: dur ,
        // privatee: pri * 1 ether,
        startTime: block.timestamp,
        endTime: block.timestamp + dur * 1 days,
        collectedMoney: 0 * 1 ether,
        numFunders: 0,
        state: 0,
        funders: funders,
        amount: amount
        });
        campaigns[campaignID] = c;

        uint[] memory agree;
        uses[campaignID] = Use({
        useDescription: "Please set Use Description.",
        amount: 0,
        agreeAmount: 0,
        disagreeAmount: 0,
        numVote: 0,
        agree: agree
        });
        return campaignID;
    }

    //函数：将nft发布到市场上



    //函数：



    function contribute(uint campaignID) public payable {
        // ID必须在范围内
        require(campaignID < numCampaigns && campaignID >= 0);
        // 贡献的钱必须大于0，而且不能超过差额
        // require(msg.value > 0);
        // 时间上必须还没结束
        require(campaigns[campaignID].endTime > block.timestamp);
        // 必须还没有收集成功
        //require(campaigns[campaignID].state == 0 || campaigns[campaignID].state == 1);

        Campaign storage c = campaigns[campaignID];
        Use storage u = uses[campaignID];
        // 使用权数量增加
        u.agree.push(0);    // 初始为没投票过
        if(c.numFunders == 0){
            c.funders.push(c.manager);
        }
        // 投资者数量增加
        c.funders.push(msg.sender);
        c.numFunders++;
        c.amount.push(msg.value);
        // 已收集的资金增加
        if(c.collectedMoney < msg.value){
            c.collectedMoney = msg.value;
            c.funders[0] = msg.sender;
        }

        // 是否满足了金额，更改状态
        // if(c.collectedMoney >= c.targetMoney)
        //已经有人出价
        c.state = 1;

    }

    function setUse(uint campaignID, uint amount, string memory desc) public {
        require(campaignID < numCampaigns && campaignID >= 0);
        //require(campaigns[campaignID].state == 3);
        require(campaigns[campaignID].manager == msg.sender); // 必须是发起者使用
        //require(campaigns[campaignID].collectedMoney == amount); // 使用的金额小于总共
        Campaign storage c = campaigns[campaignID];
        Use storage u = uses[campaignID];
        // 设置use的信息
        u.useDescription = desc;
        u.amount = amount * 1 ether;
        // 状态改变
        c.state = 4;
        c.projectDescription="3";
    }

    //用于将产品上市（改变上市金额并改变上市的描述用于所有项目显示）
    function setUse2(uint campaignID, uint amount, string memory desc) public {
        require(campaignID < numCampaigns && campaignID >= 0);
        require(campaigns[campaignID].state == 0);
        require(campaigns[campaignID].manager == msg.sender); // 必须是发起者进行上市
        //require(campaigns[campaignID].targetMoney >= amount); 

        Campaign storage c = campaigns[campaignID];
        c.projectDescription = "0";
        Use storage u = uses[campaignID];
        // 设置use的信息
        u.useDescription = desc;
        u.amount = amount * 1 ether;
        // 状态改变
        c.state = 0;
    }

    function setUse3(uint campaignID, uint amount, string memory desc) public {
        require(campaignID < numCampaigns && campaignID >= 0);
        require(campaigns[campaignID].state == 0);
        require(campaigns[campaignID].manager == msg.sender); // 必须是发起者进行上市
        //require(campaigns[campaignID].targetMoney >= amount); 

        Campaign storage c = campaigns[campaignID];
        c.projectDescription = "1";
        Use storage u = uses[campaignID];
        // 设置use的信息
        u.useDescription = desc;
        u.amount = amount * 1 ether;
        // 状态改变
        c.state = 0;
    }


    function agreeUse(uint campaignID, bool agree) public {
        Campaign storage c = campaigns[campaignID];
        Use storage u = uses[campaignID];

        require(campaignID < numCampaigns && campaignID >= 0);
        //require(c.state == 4);

        //for(uint i = 0; i < c.numFunders; i++) {
            // 该用户参与了出资
        if(msg.sender == c.funders[0]) {
            // require(u.agree[i] == 0);
            if(agree == true){
                refund2(campaignID);
                c.state=0;
                c.manager.transfer(u.amount);
                c.lastmanager = c.manager;
                c.manager = msg.sender ;
                c.projectDescription = "1";
                c.targetMoney = c.collectedMoney;
                c.collectedMoney = 0;
                while(c.numFunders > 0){
                    c.funders.pop();
                    c.numFunders--;
                }
                c.numFunders = 0;
                
                //c.amount = 0;
                campaigns[campaignID] = c;
                
            }
            else{
                c.state = 0;
                refund(campaignID);
            }
            // if(u.agree[i] == 0) {
            //         u.numVote++;
            //         // 用户同意
            //         if(agree == true) {
            //             u.agree[i] = 1;
            //             u.agreeAmount += c.amount[i];
            //         }
            //         // 用户不同意
            //         else {
            //             u.agree[i] = 2;
            //             u.disagreeAmount += c.amount[i];
            //         }

            //         // 检查此时是否过半
            //         if(u.agreeAmount >= c.collectedMoney / 2) {
            //             c.state = 2;
            //             // 使用成功，给经理人打钱
            //             c.manager.transfer(u.amount);
            //         }
            //         if(u.disagreeAmount >= c.collectedMoney / 2) {
            //             c.state = 1;
            //             // 使用失败，退钱
            //             refund(campaignID);
            //         }
                }
            }
        //}
    //}

    // 返回该项目所有参与者
    function getInvestors(uint campaignID) public view returns(address payable[] memory) {
        Campaign storage c = campaigns[campaignID];
        address payable[] storage funders = c.funders;
        return funders;
    }
    //返回该项目的说明
    function getprojectDescription(uint campaignID) public view returns(string memory) {
        Campaign storage c = campaigns[campaignID];
        string storage funders = c.projectDescription;
        return funders;
    }

    //修改项目说明
    function changeprojectDescription(uint campaignID) public{
        campaigns[campaignID].projectDescription="1";
    }
    // 返回该项目所有投票
    function getVotes(uint campaignID) public view returns(uint[] memory) {
        Use storage u = uses[campaignID];
        uint[] storage agrees = u.agree;
        return agrees;
    }

    function refund(uint campaignID) public {
        Campaign storage c = campaigns[campaignID];
        for (uint i = 1; i <= c.numFunders; i++) {
            c.funders[i].transfer(c.amount[i-1]);
        }
    }

    function refund2(uint campaignID) public {
        Campaign storage c = campaigns[campaignID];
        for (uint i = 1; i <= c.numFunders; i++) {
            if(c.funders[i] != c.funders[0]){
                c.funders[i].transfer(c.amount[i-1]);
            }
        }
    }

}
