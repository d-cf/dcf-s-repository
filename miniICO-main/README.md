# 拍卖平台

本项目是个人开发的基于以太坊(Ethereum)和智能合约的Dapp项目，内容为拍卖平台。

使用的技术栈是Typescript + React + Solidity(0.5.1)



## Avaliable Uses

在该项目中，用户可以：

- 用户可以铸造NFT，并且可以查看自己已经铸造的NFT，自己正在拍卖的NFT，目前拍卖进展和拍卖买入的NFT。
- 用户可以选择铸造的NFT并进行拍卖，规定好起拍价格和截至时间。其他用户可以浏览正在拍卖中的NFT，并进行出价。
- 用户可以查看正在拍卖NFT过去的所属权流转信息。
- 拍卖结束后，出价最高者需要手动去认领（Claim）NFT，合约会将这个NFT的所有权转到该用户的地址下



## Quick Start

- 安装Node.js(以及yarn或npm)，以太坊ganache客户端，Chrome插件Metamask。

- 使用Node.js安装truffle框架： 

  `npm install truffle` 或 `yarn add truffle`

- 打开ganache客户端。

  在ganache软件上选择 quickstart，单击右上角齿轮图标进行设置。
  在 workspace 标签页中 add project 选中 [./contracts/truffle-config.js](./contracts/truffle-config.js)，在server标签卡中将端口改为8545。

  单击右上角 save and restart。这样就将ganache连接到了8545端口。    

- 在 [./contracts](./public-offering/src/utils) 目录下运行：    

  `truffle compile` 和 `truffle migrations`

  将生成的Funding.json复制到 [./public-offering/src/utils](./public-offering/src/utils) 下（覆盖那里的Funding.json）。

  将生成智能合约的地址复制到[contracts.ts](./public-offering/src/utils/contracts.ts)文件中的第五行，替换该处的地址。

  这样就就完成了对于智能合约配置。

- 在 [./public-offering](./public-offering) 目录下运行：  

  `yarn` 或 `npm i` 安装依赖包。

- `yarn start` 或 `npm start` 运行应用。

  在[localhost:3000](http://localhost:3000)中使用应用。

- 不要忘记在Metamask中让你的测试用户连接到网站中。
