-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- ����: localhost
-- ��������: 2011 �� 05 �� 13 �� 03:34
-- �������汾: 5.0.45
-- PHP �汾: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- ���ݿ�: `jdbc`
-- 

-- --------------------------------------------------------

-- 
-- ���Ľṹ `blob_test`
-- 

CREATE TABLE `blob_test` (
  `id` int(11) NOT NULL auto_increment,
  `big_bit` blob NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- �������е����� `blob_test`
-- 

INSERT INTO `blob_test` VALUES (1, 0xffd8ffe000104a46494600010100000100010000ffdb00840009060614111014141314161215161718181718181716191614181918151514141815171d261e181a231914141f2f2324282b2c2d2c181e3235302a35262b2c2a01090a0a0e0c0e1a0f0f1a2b251f242f292a342934292d292c2d352c2c2c2c2d2c2c292c2c2c2c2e2c2c2c2c2c2c2c2c2c29292f292c2c29292c292c2c2c2c2c29ffc000110800e700da03012200021101031101ffc4001c0001000105010100000000000000000000000703040506080201ffc4004510000201030104080207050604070000000102030004112105123161060713224151718132911423425272a1b1628292c1d108153353a2f04393b2d2162463b3c2e1f1ffc4001a010100020301000000000000000000000000030401020506ffc4003011000202010204040406030100000000000001020311042112314151051361712232b1c18191a1d1f0f11423e115ffda000c03010002110311003f009c694a500a52940294a500a529402bcc920504b100019249c00071249e02acb6d6dc86ce132cee11069e6589e0aaa35663e42a12e9874ca6da0487cc56e0e56107e203834c47c67c777e11cceb5a4e6a3ccb1469a77bc479757d11b974abae68e1252cd05cb0d0c8c48801f2523594fe1c0fdaaf7d53f4b6fefda77b908d02e0248a9b9f599ef46baf7940e27c0e064f8475d06e8a1dab7650e56de2c1958684e7e1894f83360e4f8007c48ae85b2b2486358e3511a200aaaa30140e000acacbdd91d8a29e23f995e94a56c46294a500a529402950ff0059b25edb5f8952e6648a551d885721119001247bbf092701f507393e5594eaf3ad53712fd16f0aacc4fd54806eacdfb040d164fc8f23c74e359e12575494159d19265294adc885294a014a52805294a014a52805294a014a528055aed4da496f0bcd21dd441927c79003c49380078922aeaa2deb5f6a17b88adc377235ed5c7817624459f3dd0ac7f781ad2c9f045c8b1a6a1df6c6b5d4d5fa4fb7e4bd98cd2e8ab911479c8897f42e7c5bd8682b51db576553d6b2f7adc056bfb473236ea8ce3893c072e66a8d2dca5c523d2ebe11a29f26a583a1baaed8d1db6cab6ecf04cb1acd2378bbc8a1989f4d14725159bdabd21b7b5199e78e2f20ce013e8bc4fb573a5974c6feded56d639996104e0a0c48a0ea50487555c9274d79e2a8900659b563a963ab1f563a9ab72b544e0d1a19dada7b609aeebae2d9a871dabbf3586523e65457883ae8d98c706674e6f0ca07cc29a82a5da69ea3cf048f9d50942bf0c7b5158faa35b34b18ed1964e9ed93d2db3bad20b98a527ecabaef7f01d7f2acbd71d4d678d7cb811c456cdd1beb42fec48c4c678c718e625c11e4ae7bc9ec71c8d4a9e4a928b8f33a7e95aa7417ac6b7daa87b3cc532eaf0b11bc07de53f6d798e1e20695b5d64d4d6fac3d922e3674e0fc51a1950fdd78c1718f500afa31ae72db90e0abae99c10468411a8208e06ba67a5f7891585cb390a3b1906be24a15551e6492001ceb9c76ac5f5080f10a3f2155ad789c59d3d2c78f4f6a7d30c99baa1e9f1da16c6299b3730001c9c66442484974f1d30798cf8d4815ca9d5ef493e81b4e0949c2337672f96e498524fe16dd6fddaeabab27305294a014a52805294a014a52805294a014a5280542fd3f53fde9719f11111e9d981fa86a9a2a2ceb6a009730ca740f13a93ce221bf490fcaabea566b783a7e15350d545bf5fa11ded26c90aa7bcc3f8478b7fbf1af565b3c9611451b4cff0075467779b1e03de9b22da49e4508b99a73841e0883ed1e406a799a9bba37d1b8ec6dc469ab1d5dcfc4ede249aa39e189d7d66b556f8a2be27fa2e9f8be7f910c5e58c90c9d9cc811b1918208ff00f75156b791c6077f18f22743cb9fa5677a57b44cf7f33f1543d8c607162080d81e24b617dab7ee88f4156da2df9806b871963a1ecfff004d0f801e24713cb1589349e4da5ac7551176a4e52fa113c6629061774f2f2f6ad7efac4c3269f0b70e46a5ae9ef4694af6918dd71c08f06f0f63c08ad024884f0ab703a1f423423e79a960fcbc4b3f0b35935afada4b138eebd518a299ac6dd5a1074acbb0c5786152c66e2ca96e9d591c3e663b64f6f0cc934059258cef232e343e473c41e0478835353f5c93185772cc097746f97931186c6bbaaa0b119f322a2fd9f2853ad650dcaf98ad2cd44d3c4513e97c2a89c73649e7dcafb52fe7bb904b75299587c2a06ec51f2441a0f5393ceb01b727c83c862af2eb680c6056b57f75bc70385298ca72e290d7d94e9e9f2695ccc6dc0d3dabb03a337665b2b690ea5e0898fab2293f99ae4330348ca8832cc42a81e2cc4051f322bb0f63d87616f0c3c7b28d13f8142ff2ae81e60bca529432294a500a52940294a500a52940294a500a8c3af44cc368a0ead332fee98ceffe82a4fa887ad39be91b52dedc1c04451c783dc482307961573ef51daf116cb1a68f15a974fb7532fd57f47c2446e9970d28dd8f3f66153a1e45d816f4ddadab6f6d0105bcd29ff868cc39903ba3ddb03dea1fe9974b2de5d9b3b8019a498dadaa16d208210b9982783b63e2fda51e1ad63d2866e8fd98918b333c8189392c96ecc4649d4ea621ed5ce9d52514fd49d49ea2fcc9f36663ab4d81db4e67906f084e9fb53b7799b9ee86cfab0f2a941ceb50a6cce9edcdaec74b98d638d56e3b18d3777be904ef49349231d468303771a83c740251e8974953685a477083777b219739dc753865cf8ff422b4ba128c771a9bbceb5c972e4bd8b6e95c3985fd01a87edd775e65f295b1e8c15fff0091a9a3a4c3ea5ff09a85d1bff3173f893ff6d6b75be9dfb9d3f0a97fbe3ea9a2c368c586f5ab2deacb6d45ee83e46b0d378d6d5bca2e6b23e5cde076a2a9bed102b1af3106a916cd5b8d2ba9c19eba6b6897171785bc74ab626be33e2a4beaafaa66bd297778316c0e52339067c7063e51e7f8bd38d8492d914252737965df529d5f34d2a6d09d711264c00f191c1c76b8fbabae3ccebe1acf15e22895142a80aaa000000000340001a015ee8605294a014a52805294a014a52805295e6490282588000c924e00038924f0a03d52be2b02323506bed0142fafa38236965611a20cb331c000573cf49ef5ef27bab9dd64ed4a18d4fc412300267c890338f0cd6dfd64edf6b8bb6b61fe0db95c8ff3262bbd96f30818003cf27c06352b99b7467fd93e02a85f7fc5c113d2f867872956eeb1f34f1f4c919c8982456c97978ffddd12368114a28e4f2b48cc799c81e8056525d945db7caa03f873f339d4fb55bed3b2678990819d0af323c2b777466d1a43c2e7546727becd230975d26924b186cd82f670c8f22919de25f3907c0804b11eb52f7f67e989b3b95f059c11fbd18cfe82a0c6420e0f1ae94eaa7a30d63b395641bb2cac657078aef00110f30aa33cc9aceada55e3b9c18f332bd2c977607e63150e5aead2bfdf9188e606107fd35bc759bb7f0bd94672c7ba3f11f1f61afb56936f1044551e000aa93f82951efb9e93c1eacd8e6fa2c7e2ff00e14efc774d60a7e06b317cfddac2dc3774d6d4ad8b3e212ddfb187978d5ab3e2ae1aad65f1ae9ae478e93dc9e3a01d48469d9dc5eb2ced8575897fc25ce194b93ac87869a2fad4ba05627a219feefb4def8be8f0e7d7b35acbd640a52940294a500a52940294a500a529402a9dc40b2232380cac0ab023218118208f1041aa86b57d9dd2b97b3469a1df0c3568013b8c095757818ef82ac0af777f553c2a39d9086389e326526f918b83639b291e181dadca81245bbac72459dd2b242ddd6646214b2eeb10c84b649ad8365748f799229d4472b64295c98a520162118eaadbaa5b75803807058026ad36b1fa6a24969869209b74870f1f75d776646df5de002c8afc38a2f8d585d6c89a07898babccbbc629773750920196ddd01385655241c9385d7257bdcdb25a8a2ee35bd58cbead7b7a757e9c89528ca38ea681d27b729b4af41e2650e39aba215fe63dab077ea4ae46a41071e783afe552474eb67fd26da2bf89082abbb3af165404e738e26370c0f22c7c2a34bc9580ca60f2278fbd6d656fcce25c99eb341a984f49c2f9ad9f7f72b4174ac01073fefcaa8ed391421cf8f0ab186149bbd828e3e219d41f6e3559f63237c5963cc9ad14231965b2e3b6db6b7c114f3d73b7e58c986b5803cc0fc32261d5b43aa904641d0eb8adf2e3a77b4a55c76d1c59e26389413e7ab16c7b56bd6db3550e40d718f6f2abe02b375a9bd8ada7f0c84a39bd6e594f60eefda3ccecfe671fa634af462603e226ae9a502a97d317866a3e39cb765d545156d1dbf1313348d9209ac7df3e171591bd61bc48ac1decb93576a8e5a3ce6bece04d6725a39d2bd6c7d96d75731409f14aea8396f1c12790193ed56f33d4bffd9ffa185a47bf917ba998e0cf8b9d24907203bb9f366f2aba79f271b784222a8e0a001e8060554a528645294a014a52805294a014a528057c570781cffbc1afb5a76d0e8f7d164696156ec9d999fb22cb2c4ec4b33e13fc68cb124a90597248de1a2e9649c2394b3f532964dc6b4eda96132dcbc7045bdda9ed559b78431923766df700e09288428d49909e00916db436e4cb1068e79086c0126237445209ed58471166518e0389206546586c96bd22b610ab1bb85c000190c9180c40d49c10013c71e15414f4fe25538f38a7bf4e5fa9262553c9ab6ccba78e4768c76130ff001ade4d11db80662a34ce0e264c860350d8c2e52ff6d7d2044a2392328e24937d71ba543058d5be190b36355246ee4e7500d0db9751ddb44d0a905181fa490514267eb2250c37a60e06318dc1a36f65455237085bb32fdeddcee860240a72bbe071033e38c66b83acd64f419d3572528b5b67770f47dd762cc2b567c6d63ee653a13931ce7ec1b9937398010487fe7096b09d21ea921959a4b57fa2b9c9298de8598eb9dcc829afdd38e55597a52bb36d562788b84012dca709b1c15ffcb900cb313a1c12324951ad4dd64deb1c868d3904c81cb2c4935e86aba985308a79584b3ecb04ba6d1ea2e939d5b7e869bd22e88de58b19258b7547fc443bf0b0f22d8ca7ef0156906d0571c707c4788f6a953a15d63fd2e736776a85dc36e305ee4981968dd0e403bb923c08046878e2ba5dd4b6ad2d8635d7b063ba079f6527d9fc2da731534ea5359458a35d6e966e13346edf156d73b5028e3543696c592ddfb39fb5b772321640ba8e19561a30e609ab75b0878b3173cce9f2aafe5453dceb3d75b64730c2f5cafeff00428c976f364460e3c5cfc23d3cebec1b2b778bb13eb81f2ab99368c6ba0f603fa5536998eb8c7eb532cfb1cf9796de64f8a45ade129ceb1133e726b237ee48ab9e84ec117bb42deddf3b8efdfc1c1dc505dc03e190a4679d5982c238da9966785c8bfeae7ab7976a4e1983476ca7eb25c7c58ff87193c58f9fd9f1f007a72c2c52089228942468a155470500600a585847046b1448b1c6830aaa301479015715b15c5294a014a52805294a014a52805294a014a5280d7f6af4609632db3886424b32b64c321f12ca0828da7c4b8e61ab1c3675c6779ad417fbc8f0b7c9df75be62b71a573b51e1b45f2e269a7dd3c67df1cc9636ca3b1a8c7b06ea66efb2db278904493b7a123b38fd7bfed59197a1b6e63dd5528f9de13024cc1f1bbbfda364b1c6986ca91a631a5676a9dc48551881920120799032054946874fa78b8c22b7e7d5bf76cc4ac949eec867a7774cb8b7721ae207593eac66395195972753d939539dc6f624106b539f6b26e120ebe5c0fa60d5e5b4c5d77d89677efb93c599bbcc4fb9ab6da8abba49504fa550a2aaab979705b65eddbfe1ec69a6cd3e99c94b76b3cbd3a1f3abf4326d3b790b2c71c520777775551a1c2e588cb367181aeb5d1d05da3e771d5f1c77581c7ae2b9362886ba03a9e3e5a60579b72639014250f0ca92a47a15c115dce8790b136f2fa930f5ccf14b35bc580ce89217fd90e63dc07c89dc27db9d4707a3f1f911fbc7fad57b691c8cee3393a96661963e64b1c9f53554dee3e3464e6469f31915ccb6c9b93e13d5e874da78d295ab7eed7dca50ec98d3828aaad6a0f85560e0f039a541c727cd9d4545515f0c560c56d0d9a3749ab7e80ed94b3da96d34877515cab9f0557568c93c86f67d2afee6e032b72ad3ae8e49f5ae8e9dcb0d48f25e2caae38cabe4cecc06bed695d4f6dd375b2612cdbcf16616d75ee1ee67f70a56eb564e38a52940294a500a52940294a500a52940294a500a52940294a50111f4efabe92d8497369f591962cf11d0c4a7566523e2404938c640f302a39b9b79e41dedd55e477b3f2aea2ad2f68f5536b23168de5b7de24958d977013c7755d5b7472181caa0956f39860ea51ad5c3e5dee4d7a3faff00640573188d704f0f99e756409186e041ca8e7e071fcab7feb03ab19acb7ee233dbdbaeef79dc76a992a982b80ac378f11e078695abeccd9e430772323801c01f327c4d6f29a847734aa97a9b715ecbbf633d01254123048191e471a8af6457c56af2f3015c4c36cf74be15b98cbbb2646de8ce3f67ec9e7c8d59cb792f02a7e631f3abeb9bdac6cf755d1aa326b7479bd6d95c73e5c9a5d574fc8f719c4796e27535addc6a4d642eeecb6958e7ab70870f3381a8b95984b92267fece173dcbd8fc9a271ee2453ff48a99ea0efece03eb2f7f0c3facd538d6e5714a52805294a014a52805294a014a52805294a014a52805294a014a5280b2db5b252eade4824194914a9c7119e0c398382398ae66bd636f3cb09265ec9d93b455387dd2577c2f10320f2c83ad74d6d8bb315bcd20e291bb8fdd52dfcab9ce7d962445d48603461c7cce7cc1355eeb231c711d6f0ed3db6a9cab7cb1b772d22da39e07e608fd6be4975e66aceeadda3f8867983a7be7855a3dd01588c22f744f6ea2c87c366725dcb2e6acee26c5509368674506afb66f4767b91940801382cce0053e4c06587caa494e152cc9e0e5db6bb36898c95b3e3541856676f744a7b260260371b1bb226b1b72def03c8e3966b132458e159aed8db15383ca7d4ace2e2f0ce80ea27a322dec0dc9397ba39c7dd442ea83d49de3ee2a4ca8f3a8bdae26d92b1fdab791e361c89ed10fa61f1ec6a43a900a52940294a500a52940294a500a52940294a500a52940294a500a5294051bdb512c4f1b7075653e8c0a9fd6b9ea28de2678251bb242dd9b8e6ba061c88c30e46ba2ea2deb8760245bb7eac11c958a4527025e3b847eda807d57f08aafa8abcc8edccea785eaff00c6b7e2f95eccd1a78030ac35c6c48cf863d3fa55e47b6548d74aa335ea9e04550ad591783d4dd2d35d1ccb0cc735808f8014b7b868df7d18a30f11e23eeb03a30e47db14bbb9cf0ab2927c574631728e24796d4f9516f8391bff0047fa68ae0c528505b431beb14b9fbbbde3fb275f5ac774afa130a4325cdab6e2a0de9207fb2320131b71c6bf09cf2238568d35d674e39aad3ede9da1ec5a5668f4c838c900e402df1300403827c079573bff003a555cacd3cb8537bae8d7f39755dca4ed525892377ea37a4df46da0606384ba1bba9d04ab931fcf2cbea457455718c2ecac19490ca41046841072083e04100d74cf565d6126d2b70aec05d46bf5a98c6f634ed547dd3a671c09c7967ac406eb4a52b205294a014a52805294a014a52805294a014a52805284d626fba576909c49711023ec860cdfc2b93f950ca5932d4ad627eb26c1065a62a39c53807d094d6b16fd72d8e70a2e24fc30b7f320d632834d6ecdeeb4beb7b6619b654c5465a12b30f443dfff00433d7cbdeb35563de8eceee463c014545fde6de3ba3d89e55a7ed6e935fdd931bcb6eb0b82b2410b98e5208f84c920c9d38e319a8ddb05d48676d715bb5f735083a1cc537cc326ba83ae307518dde15aded3d9ef116ce70a4711ae09c673c8e95bb4e2184843f48b7380077b7f18d06a841c7b56136cdebcaacb99271a26feeb36eebbda9e3e1a0355a13964e453abbe33f99b5ebbff004622db65f68324ea7d455b5cec7903001b427009f0e55bad95ee2354fa7766400376489b7472d4301569b5549ddefc128ded1a2dd07dd5707f2ad95b2cff003f60f5572939e767d0d6bff0cb01977f90fe7545b65966448f0599828c91ab31c282c7419381e5ad6d1d909248d1be1d491f7b18d3f3fcab17d26b544902c6373790920781046eb0f23c7e552d72949659d4a6739c38e460a6b7786468e4468dd4e191810ca7c88357bb3ef5e1916581cc5221cab2e8479fa83e20e86a79d9bb0ad36fecbb79ae23fad318569570b2a489947efe351bca4e0e46bc2a3de907529796b96b7c5e47ae8b84940e68c70dfba7daa72c1ba743faeb865558ef7ea24d07680130b9f33e319f5d398a9321995d432b0652320820823cc11a115c8d3c4d1b94915a371c55d4ab0fdd6c1ac96c5e93dd599cdbcef10ce7741cc67d636ca9f9501d554a84364f5f170800b88239f1f6918c6c79904329f6c56d9b2baf0b097025ed6d8feda6f2ff00147bdf981404874ac4ecce965a5cff0083730c87c9645defe1ce47cab2a0d01f694a500a52940294a500ad7f6a7485c4ad142a3b806fc8d92aa4fd955041623427240191c75c6c15a76d33f43ba799c1ec2439dfc121490a19588f8754de04e877b1c4547636a3b1256937b9789b212701a77375c98fd50f485709fc409e759182d1231844541e4aa147c80ac7db25acfdf8cc6f9fb48d83f3520d51da9b323084f7c93c3beec3f3354379bc364f85cbec51e98089add95f049f8403decf811517ec6e8adcccfbd6e995c90cc48110e7bde2de7ba0f3c1acb4799eebe8f2e5637de1ddee9200c919f00735206ccb8fa2c4b1ba1545d14aa92a073ddce2ac4d7970e0e66b282945a6b29f4358b6eaa19b59ae774f9451a8ff0053e49f957bbfeaa414c2ddce47938471ec08d3dab728f6f5bb709a3f7651fa9afb3edd81064cd1fb3a927e46aa2e2cf2218d5082e15058edc2bf620cda9b1e7b32cac5641f84671c783641f98aa31caa53ea95632783465d49f51bd8adb7a5db5a294b9de53a70c8ad0767dfa46ce09d090c391390dfa03ef576cab10525cfb1cfd6e8a2e39a961f6e8579ad59cfd64923fa9fe7c6bddbd92af018e7ff00dd529f6e2f860d5a3ed176e00fb035146164b6c14ebd1cdfce5d5ebae374ebfafa83e06b14d18d4ebaf89249f99ab85b576e3ddf5d4fcaabc5683795403239385500b313e4aa0649f4ab95e9e51597b1d08251f863b9277507b48f63736c7ecb8953d1c6ebfc9901fdea966a36eaa7a1b3db492dc4e9d8efa04442417c6f0666603e1e0a003af1e1524d6ef1d0b0b916bb4365c5708526892553e0ea187e7c2b46dadd4858ca4988c96c4f8236f27f0480e3d88a90e9583241db4fa85ba5c982e2294793ab467e63787e95ad5f7553b4e3e36a641e71c91b7e5bc0fe55d2d4ac601c9d73d12bc4f8ecee57998243f9814b39e6b7398ae6581bc833c67d3048ae9edbdd24b7b188497328890b0504e4924f928c938e271c0026af25823953bcab22119d406520f03ae84561c7b3248492f9964e7dd93d6aed4b63de916e57ca55d7d9d70df99a90ba2fd76dadc308ee54d9c874058e6163ca4c0ddfde0073acd6d9eabec6e01c45d831fb51614679a7c07e5ef50874bba26d6933c12e095c32b0e0c873bae3cb81c8f3078f1a8dca51e6598d55dcbfd6f0fb3fdce9b56c8c8d457da853a8ee9c49daff00774cdbebbacd031d4aeeead17e1ddc91e5823863135d4c5214a5280508a5280c45c744ad1ce4db45bde6102b7f12e0d53ffc1769fe57fae4ff00bab374ac611b71cbb9addcf40adb1985041203bcb22e5883a8c3063de520904647220806bd879a25fad8cb63ed4597cf3ddf8bf2ad8695aceb53e66d1b1a34ebbdb9647fc678c7295374fca451588bab9d8a4779acbdbb3cfcd75a922a83584678c6873fb2bfd2a2f231c99bf9be873bf48e6b2594880a15f021811fad61f7e23c307d35fd2ba6ff00b9a0ff00262ff969fd2ae21b654f85557d001fa55d8dae2b1845794549e7739a6d3654b27f856d349f86190fe7bb8acf587575b466d45bf623ce5755ff004aef37e553e52b3e74cd7cb87622dd8fd4b1d0dd5c67f621181e864719f928adf3627452d6cf3f478523278b6ace791762588e59acb52a26dbdd9badb64294a5600a57c26b45e93f5af05b931db817320d0b06c4287c8b8f8c8f25f98ac3692cb378572b1f0c5659bc4d3aa296760aa0649620003cc93a0a8f7a47d6fc4994b34eddf8768d9585798fb527b601f3a8d76f74b65bb6cdccdbe33a2038897cb763071ee7279d61df6cc23ed8f98feb55e5737f2a3ad4f87c16f7cd2f4cfdcc86d6bb96edfb4b990ccf8c02d801471dd441a28f4f7cd6ff00d5f759b6b6b60b05dcacaf09644ee48fbd1e73180501ce01ddd71f0d45336de8f806156fb3a26bcb98ade265469582877255413e6719e5cc903c6b5ab8f3966fadff0019c1460d6dd89936df5ef0229fa3c4f237834b88d3d700976f4c0f5a863a47d3096ea579247df76e2718000e0aa3c1454976dfd9c998e66bef648bf9b3ff002add3a3bd4c6ceb4218c46e1c63bd390e01f308004fc8d59e1cf3391e670ed0dbd7a9a3f511d0894cc7684ca5502b2c19c82e5b46900fba172a0f8e4f954e55f00c57dad8885294a014a52805294a014a52805294a014a52805294a014a52805294a0285f58a4d1b4722874718653c181e20f2ac247d5dece5e16707ba03fae6be5280bc8fa2164bf0da5b0f4862ff00b6af20d930a7c1146bf85147e8294a02b8b65fbabf215f7b15f21f214a501ee94a500a529407ffd9);

-- --------------------------------------------------------

-- 
-- ���Ľṹ `clob_test`
-- 

CREATE TABLE `clob_test` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `big_text` text character set utf8 collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- �������е����� `clob_test`
-- 

INSERT INTO `clob_test` VALUES (1, 0x0d0ae38090e8a782e79c8be9a1bbe79fa53ae380910d0a0d0a20202020e69cace5a597e8a786e9a291e69599e7a88be4b8bae4bca0e699bae692ade5aea24a444243e8a786e9a291e69599e7a88befbc8ce69599e7a88be98787e794a8e79a84415649e696b9e5bc8fe58f91e5b883efbc8ce68980e4bba5e79c8be8b5b7e69da5e5be88e6b581e79585efbc8ce5a4a7e5aeb6e58fafe4bba5e9809ae8bf87e58c85e4b8ade99984e5b8a6e79a8443616d506c61792e657865efbc88e68b96e585a5e58db3e58fafefbc89e8a782e79c8be5928ce5ada6e4b9a0e380820d0a0d0ae38090e8a786e9a291e4bb8be7bb8defbc9ae380910d0a2020200d0a20202020e4b880e4ba9be8a786e9a291e69599e7a88be9809ae8bf87e6b585e698bee6a188e4be8be69da5e8aea9e5889de5ada6e88085e6849fe588b0e8bdbbe69dbeefbc8ce4bd86e698afe8afbee7a88be4b8ade7bc96e58699e79a84e4bba3e7a081e4b88de883bde79bb4e68ea5e5ba94e794a8e4ba8ee9a1b9e79baee4b8adefbc9be8808ce69cace5a597e8a786e9a291e69599e7a88be6ada3e5a5bde79bb8e58f8defbc8ce8a786e9a291e8aeb2e8a7a3e88085e69d8ee58b87e88081e5b888e4bba5e68a80e69cafe8a781e995bfefbc8ce680a7e6a0bce69cb4e5ae9ee697a0e58d8ee38081e4b88de59684e4ba8ee5b9bde9bb98e6909ee7ac91efbc8ce69d8ee58b87e88081e5b888e7bc96e58699e79a84e4bba3e7a081e99d9ee5b8b8e4b893e4b89ae5928ce5ae9ee794a8efbc8ce695b4e4b8aae58685e5aeb9e983bde698afe98787e794a8e5ae9ee99985e9a1b9e79baee4b8ade5ba94e794a8e79a84e9ab98e6b0b4e58786e4bba3e7a081e38081e7ab99e59ca8e8be83e9ab98e5b182e6aca1e4b88ae8bf9be8a18ce6b7b1e585a5e8aeb2e8a7a3efbc8ce68980e4bba5efbc8ce5889de5ada6e4babae59198e5ada6e4b9a0e69cace8a786e9a291e69599e7a88be59ca8e5bc80e5a78be697b6e4bc9ae6af94e8be83e59083e58a9befbc8ce58fafe883bde5bf85e9a1bbe88090e5bf83e5ada6e4b9a0e5a49ae9818de6898de883bde6b890e585a5e4bdb3e5a283efbc8ce4bd86e4bda0e4b880e697a6e68e8ce68fa1e4ba86e585b6e4b8ade79a84e58685e5aeb9efbc8ce789b9e588abe698afe68e8ce68fa1e4ba86e69d8ee58b87e88081e5b888e68980e7bc96e58699e79a84e982a3e4ba9be4bba3e7a081efbc8ce4bda0e79a84e7bc96e7a081e883bde58a9be5b086e4bc9ae79bb8e5bd93e587bae4bc97efbc810d0a20202020e5afb9e696b0e6898be69da5e8afb4efbc8ce8bf99e882afe5ae9ae4b88de698afe69c80e5a5bde79a84e8a786e9a291e69599e7a88befbc8ce4b88de8bf87efbc8ce794b1e4ba8ee4bca0e699bae692ade5aea2e6b187e8819ae4ba86e5a49ae5908de59084e585b7e789b9e889b2e79a84e69599e5b888efbc8ce58c85e68bace883bde794a8e9809ae4bf97e5bda2e8b1a1e79a84e696b9e5bc8fe8aeb2e8a7a3e59084e7a78de5a48de69d82e997aee9a298e79a84e69599e5ada6e9ab98e6898be5928ce8a7a3e586b3e59084e7a78de68a80e69cafe79691e99abee997aee9a298e79a84e68a80e69cafe5ae9ee68898e9ab98e6898befbc8ce5908ce4b880e997a8e79a84e8afbee7a88befbc8ce68891e4bbace69c89e5a49ae5908de88081e5b888e983bde58fafe4bba5e8aeb2e8a7a3efbc8ce58fafe4bba5e99288e5afb9e59084e7a78de5b182e6aca1e79a84e5ada6e59198e98787e794a8e4b88de5908ce79a84e6898be6b395e8bf9be8a18ce59ba0e69d90e696bde69599e38082e69cace8a786e9a291e69599e7a88be5afb9e5a496e58f91e5b883e79a84e4b8bbe8a681e79baee79a84e698afe5b88ce69c9be883bde5a49fe5b8aee58aa9e982a3e4ba9be69c89e4ba86e4b880e4ba9b4a444243e7bc96e7a88be59fbae7a180e8808ce683b3e6b7b1e585a5e68f90e9ab98e79a84e69c8be58f8be5ada6e4b9a0e5928ce58f82e88083efbc8ce4b8bae4ba86e785a7e9a1bee5889de5ada6e4babae59198e5bfabe9809fe4b88ae6898befbc8ce68891e4bbace4b88de4b985e4b99fe4bc9ae59ca8e68ea8e587bae794b1e585b6e4bb96e88081e5b888e8aeb2e8a7a3e79a84e9809ae4bf97e69893e68782e59e8be79a844a444243e8a786e9a291e69599e7a88be380820d0a0d0a0d0ae38090e8a786e9a291e79baee5bd953ae380910d0a0d0a2020202030315f6a646263e79a84e79086e8aebae6a682e8bfb00d0a2020202030325fe7bc96e58699e4b880e4b8aae7ae80e58d95e79a846a646263e4be8be5ad90e7a88be5ba8f0d0a2020202030335fe58886e69e906a646263e7a88be5ba8fe79a84e7bc96e58699e6ada5e9aaa4e5928ce58e9fe790860d0a2020202030345fe8a784e88c83e5928ce5b081e8a3856a646263e7a88be5ba8fe4bba3e7a0810d0a2020202030355fe7ad94e79691e5ada6e59198e68f90e587bae79a84e58d95e4be8be997aee9a2980d0a2020202030365fe5ae8ce68890e5afb9e695b0e68daee5ba93e79a8443525544e6938de4bd9c0d0a2020202030375f53746174656d656e74e79a8473716ce6b3a8e585a5e997aee9a2980d0a2020202030385f507265706172656453746174656d656e74e79a84e5ba94e794a80d0a2020202030395fe7ad94e79691e5ada6e59198e79a8465636c69707365e4bdbfe794a8e997aee9a2980d0a2020202031305f6a646263e4b8ade79a84e695b0e68daee7b1bbe59e8be4b88ee697a5e69c9fe997aee9a2980d0a2020202031315fe794a86a646263e8aebfe997aee5a4a7e6aeb5e69687e69cace695b0e68dae0d0a2020202031325fe794a86a646263e8aebfe997aee4ba8ce8bf9be588b6e7b1bbe59e8be79a84e695b0e68dae0d0a2020202031335f6a646263e8aebfe997aee585b6e4bb96e59084e7a78de695b0e68daee7b1bbe59e8b0d0a2020202031345fe7ad94e79691e5ada6e59198e79a84e7b4a2e5bc95e58fb7e997aee9a2980d0a2020202031355fe58886e69e90e59ca8e5ae9ee99985e9a1b9e79baee4b8ade8afa5e5a682e4bd95e5ba94e794a86a6462630d0a2020202031365f44414fe8aebee8aea1e6809de683b3e4b88ee690ade5bbbae9aaa8e69eb60d0a2020202031375fe7bb93e5908853657276696365e5b182e8aeb2e8a7a344414fe5b182e79a84e5bc82e5b8b8e5a484e790860d0a2020202031385fe5ae8ce68890e695b4e4b8aa44414fe79a84e5ae9ee78eb0e58f8ae6b58be8af95e4bba3e7a0810d0a2020202031395fe4bdbfe794a844414fe5b7a5e58e82e6a8a1e5bc8fefbc88e4bba3e7a081e8b685e7bb8fe585b8efbc890d0a2020202032305fe4ba8be58aa1e79a84e6a682e5bfb5e4b88e4a444243e4ba8be58aa1e5a484e790860d0a2020202032315fe4ba8be58aa1e79a84e4bf9de5ad98e782b9e5a484e790860d0a2020202032325f4a5441e58886e5b883e5bc8fe4ba8be58aa1e79a84e7ae80e8a681e4bb8be7bb8d0d0a2020202032335fe4ba8be58aa1e79a84e99a94e7a6bbe7baa7e588ab0d0a2020202032345fe4bdbfe794a84a444243e8b083e794a8e5ad98e582a8e8bf87e7a88b0d0a2020202032355fe4bdbfe794a84a444243e79a84e689b9e5a484e79086e58a9fe883bd0d0a2020202032365fe58fafe6bb9ae58aa8e7bb93e69e9ce99b86e4b88ee58886e9a1b5e68a80e69caf0d0a2020202032375fe58fafe69bb4e696b0e5928ce5afb9e69bb4e696b0e6958fe6849fe79a84e7bb93e69e9ce99b860d0a2020202032385fe695b0e68daee5ba93e79a84e58583e695b0e68daee4bfa1e681af0d0a2020202032395fe58f82e695b0e79a84e58583e695b0e68daee4bfa1e681af0d0a2020202033305fe588a9e794a8e7bb93e69e9ce99b86e58583e695b0e68daee5b086e69fa5e8afa2e7bb93e69e9ce5b081e8a385e4b8ba6d61700d0a2020202033315f4a617661e58f8de5b084e68a80e69cafe585a5e997a80d0a2020202033325f4a617661e58f8de5b084e79a84e69bb4e5a49ae7bb86e88a820d0a2020202033335fe588a9e794a84a617661e58f8de5b084e68a80e69cafe5b086e69fa5e8afa2e7bb93e69e9ce5b081e8a385e4b8bae5afb9e8b1a10d0a2020202033345fe7bc96e58699e4b880e4b8aae59fbae69cace79a84e8bf9ee68ea5e6b1a0e69da5e5ae9ee78eb0e8bf9ee68ea5e79a84e5a48de794a80d0a2020202033355fe5afb9e59fbae69cace8bf9ee68ea5e6b1a0e8bf9be8a18ce4b880e4ba9be5b7a5e7a88be7bb86e88a82e4b88ae79a84e4bc98e58c960d0a2020202033365fe9809ae8bf87e4bba3e79086e6a8a1e5bc8fe69da5e4bf9de68c81e794a8e688b7e585b3e997ade8bf9ee68ea5e79a84e4b9a0e683af0d0a2020202033375f4a617661e79a84e58aa8e68081e4bba3e79086e58f8ae4bdbfe794a8e8afa5e68a80e69cafe5ae8ce59684e8bf9ee68ea5e4bba3e790860d0a2020202033385fe6a087e5878644617461536f75726365e68ea5e58fa3e58f8ae695b0e68daee6ba90e79a84e680bbe7bb93e4bb8be7bb8d0d0a2020202033395fe5a682e4bd95e4bdbfe794a8e5bc80e6ba90e9a1b9e79bae44424350efbc88e5ae9ee99985e9a1b9e79baee4b8ade5b8b8e794a8efbc890d0a2020202034305fe5b08644414fe4b8ade79a84e4bfaee694b9e696b9e6b395e68f90e58f96e588b0e68abde8b1a1e788b6e7b1bbe4b8ad0d0a2020202034315fe4bdbfe794a8e6a8a1e69dbfe696b9e6b395e8aebee8aea1e6a8a1e5bc8fe5a484e7908644414fe4b8ade79a84e69fa5e8afa2e696b9e6b3950d0a2020202034325fe4bdbfe794a8e7ad96e795a5e6a8a1e5bc8fe5afb9e6a8a1e69dbfe696b9e6b395e8aebee8aea1e6a8a1e5bc8fe8bf9be8a18ce694b9e8bf9b0d0a2020202034335fe4bdbfe794a84a64626354656d706c617465e5b7a5e585b7e7b1bbe7ae80e58c96e5afb9e8b1a1e69fa5e8afa20d0a2020202034345f4a64626354656d706c617465e7b1bbe4b8ade79a84e585b6e4bb96e59084e4b8aae69fa5e8afa2e696b9e6b3950d0a2020202034355fe4bdbfe794a84a64626354656d706c617465e5ae8ce68890e695b0e68daee5ba93e4bfaee694b9e5928ce585b6e4bb96e58a9fe883bd0d0a2020202034365fe4bdbfe794a8e694afe68c81e591bde5908de58f82e695b0e79a844a64626354656d706c6174650d0a2020202034375fe4bdbfe794a853696d706c654a64626354656d706c617465e5928ce6b39be59e8be68a80e69cafe7ae80e58c96e4bba3e7a0810d0a2020202034385fe4bdbfe794a84a64626354656d706c617465e5ae9ee78eb044414fe5928ce794a8e5b7a5e58e82e781b5e6b4bbe58887e68da2e5ae9ee78eb00d0a2020202034395fe68980e69c89e6ba90e7a081e4b88e7070740d0a0d0a0d0ae38090e8aeb2e5b888e4bb8be7bb8d3ae380910d0a0d0a20202020e69d8ee58b87efbc8ce69d8ee58b87e88081e5b888e79a84e68a80e69cafe58a9fe5ba95e99d9ee5b8b8e6b7b1e58e9aefbc8ce8afbee7a88be58685e5aeb9e7bb84e7bb87e5be97e99d9ee5b8b8e59088e79086e5928ce5b7a7e5a699efbc8ce79fa5e8af86e782b9e79a84e8aeb2e8a7a3e4b99fe5be88e7bb86e885bbe5928ce9808fe5bdbbefbc8ce680bbe7bb93e4ba86e8aeb8e5a49ae78bace69c89e79a84e7bb8fe9aa8ce38082e887aae4bb8ee69d8ee58b87e88081e5b888e79a8448696265726e617465e69599e7a88be585ace5b883e4bba5e69da5efbc8ce4b88de4bb85e5be97e588b0e4ba86e5889de5ada6e88085e79a84e4b880e887b4e882afe5ae9aefbc8ce8aeb8e5a49ae69c89e7bb8fe9aa8ce79a84e5bc80e58f91e4babae59198e590ace5ae8ce69d8ee58b87e88081e5b888e79a84e8afbee7a88be5908eefbc8ce4b99fe59091e68891e4bbace58f8de9a688e69c89e5be88e5a4a7e79a84e694b6e88eb7efbc8ce7bb99e4ba88e4ba86e5be88e9ab98e79a84e8af84e4bbb7e380820d0a20202020e5b882e99da2e4b88ae79a844a444243e7bc96e7a88be8a786e9a291e4b880e888ace983bde698afe8aeb2e8a7a3e4b9a6e69cace4b88ae4b880e4ba9be78eb0e69c89e79a84e4b89ce8a5bfefbc8ce5b091e69c89e887aae5b7b1e79a84e7bb8fe9aa8ce5928ce5bf83e5be97efbc8ce8bf99e4b880e782b9e5afb9e4ba8ee5889de5ada6e88085e69da5e8afb4e698afe8bea8e588abe4b88de587bae69da5e79a84e38082e69d8ee58b87e88081e5b888e79a84e68a80e69cafe5ae9ee58a9be5b7b2e7bb8fe5be97e588b0e4ba86e5b9bfe5a4a7e4b880e7babfe5bc80e58f91e4babae59198e79a84e9ab98e5baa6e8aea4e58fafefbc8ce79bb8e4bfa1e4bda0e79c8be8bf87e69cace5a5974a444243e8a786e9a291e5908eefbc8ce5908ce6a0b7e4b99fe4bc9ae58f91e587bae8bf99e7a78de6849fe685a8efbc8ce69cace8a786e9a291e4b88de698afe8aea9e4bda0e4ba86e8a7a3e79aaee6af9befbc8ce8808ce698afe794b1e6b585e98090e6ada5e6b7b1e585a5e5928ce7b2bee9809a4a444243efbc810d0a202020200d0a0d0ae38090e88194e7b3bbe68891e4bbac3ae380910d0a0d0a20202020e4bca0e699bae692ade5aea2e7a59de684bfe5a4a7e5aeb6e5ada6e4b9a0e9a1bae588a9efbc8ce5a682e69e9ce59ca8e5ada6e4b9a0e8bf87e7a88be4b8ade98187e588b0e997aee9a298efbc8ce58fafe4bba5e9809ae8bf87e4bba5e4b88be696b9e5bc8fe4b88ee68891e4bbace88194e7b3bbefbc9a0d0a202020200d0a20202020e7bd91e59d80efbc9a687474703a2f2f7777772e6974636173742e636e2020e794b5e8af9defbc9a3031302d3531353532313131202020452d6d61696cefbc9a697463617374406974636173742e636e0d0a0d0a0d0a);
INSERT INTO `clob_test` VALUES (2, 0x7061636b61676520636e2e69626d2e6f6e6568616f3b0d0a0d0a696d706f7274206a6176612e73716c2e436f6e6e656374696f6e3b0d0a696d706f7274206a6176612e73716c2e4472697665724d616e616765723b0d0a696d706f7274206a6176612e73716c2e526573756c745365743b0d0a696d706f7274206a6176612e73716c2e53514c457863657074696f6e3b0d0a696d706f7274206a6176612e73716c2e53746174656d656e743b0d0a0d0a2f2a2a0d0a202a200d0a202a2040617574686f72206f6e6568616f0d0a202a204073696e636520323031312d30352d30340d0a202a204073656520e4b88de4bc9ae4baa7e7949fe5ae9ee4be8be79a84e7b1bb0d0a202a2f0d0a0d0a7075626c69632066696e616c20636c617373204a6462635574696c73207b0d0a09707269766174652073746174696320537472696e672075726c203d20226a6462633a6d7973716c3a2f2f6c6f63616c686f73743a333330362f74657374223b0d0a09707269766174652073746174696320537472696e672075736572203d2022726f6f74223b0d0a09707269766174652073746174696320537472696e672070617373776f7264203d2022313233343536223b0d0a090d0a0970726976617465204a6462635574696c7328297b0d0a09090d0a097d0d0a090d0a097374617469637b0d0a0909747279207b0d0a090909436c6173732e666f724e616d652822636f6d2e6d7973716c2e6a6462632e44726976657222293b0d0a09097d2063617463682028436c6173734e6f74466f756e64457863657074696f6e206529207b0d0a0909092f2f20544f444f204175746f2d67656e65726174656420636174636820626c6f636b0d0a0909097468726f77206e657720457863657074696f6e496e496e697469616c697a65724572726f722865293b0d0a09097d0d0a097d0d0a090d0a097075626c69632073746174696320436f6e6e656374696f6e20676574436f6e6e656374696f6e2829207468726f77732053514c457863657074696f6e7b0d0a09092f2fe5bbbae7ab8be8bf9ee68ea50d0a090972657475726e204472697665724d616e616765722e676574436f6e6e656374696f6e2875726c2c20757365722c2070617373776f7264293b0d0a097d0d0a090d0a097075626c69632073746174696320766f6964206672656528526573756c745365742072732c53746174656d656e742073742c436f6e6e656374696f6e20636f6e6e297b0d0a09097472797b696628727320213d206e756c6c290d0a09090972732e636c6f736528293b202f2fe981bfe5858de68a9be587bae5bc82e5b8b8e585b6e4bb96e8afade58fa5e4b88de689a7e8a18ce38082e68980e4bba5e58d95e78bace694bee59ca87472792066696e616c6c7920e585b6e4bb96e4b8a4e4b8aae7b1bbe4bcbc0d0a09097d63617463682853514c457863657074696f6e2065297b0d0a090909652e7072696e74537461636b547261636528293b0d0a09097d66696e616c6c797b0d0a09090d0a0909097472797b0d0a09090909696628737420213d206e756c6c290d0a090909090973742e636c6f736528293b0d0a0909097d63617463682853514c457863657074696f6e2065297b0d0a09090909652e7072696e74537461636b547261636528293b0d0a0909097d66696e616c6c797b0d0a09090909696628636f6e6e20213d206e756c6c297b0d0a09090909097472797b0d0a090909090909636f6e6e2e636c6f736528293b0d0a09090909097d63617463682853514c457863657074696f6e2065297b0d0a090909090909652e7072696e74537461636b547261636528293b0d0a09090909097d0d0a090909097d0d0a0909097d0d0a09097d0d0a09090d0a097d0d0a7d0d0a);

-- --------------------------------------------------------

-- 
-- ���Ľṹ `user`
-- 

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) character set utf8 collate utf8_bin NOT NULL,
  `password` varchar(20) character set utf8 collate utf8_bin default NULL,
  `groups` varchar(20) character set utf8 collate utf8_bin default NULL,
  `birthday` date default NULL,
  `money` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

-- 
-- �������е����� `user`
-- 

INSERT INTO `user` VALUES (1, 0x6f6e6568616f, 0x313233, 0x6731, '0000-00-00', NULL);
INSERT INTO `user` VALUES (2, 0x74657374657231, 0x313233, 0x6732, '0000-00-00', NULL);
INSERT INTO `user` VALUES (5, 0x646464313131, 0x656565, 0x6366666363, '0000-00-00', NULL);
INSERT INTO `user` VALUES (6, 0x6f6e6568616f, 0x70617373, 0x6733, '0000-00-00', NULL);
INSERT INTO `user` VALUES (7, 0x6f6e6568616f, 0x70617373, 0x6733, '0000-00-00', NULL);
INSERT INTO `user` VALUES (8, 0x6f6e6568616f, 0x70617373, 0x6733, '0000-00-00', NULL);
INSERT INTO `user` VALUES (9, 0x6e657731, 0x3230313130353034, 0x6731, '0000-00-00', NULL);
INSERT INTO `user` VALUES (10, 0x6e657732, 0x3230313130353034, 0x6732, '0000-00-00', NULL);
INSERT INTO `user` VALUES (11, 0x646174655465737431, 0x70617373, 0x6735, '2011-05-09', 500);
INSERT INTO `user` VALUES (12, 0x64616f206e616d6531, 0x64616f2070617373, 0x64616f2067, '2011-05-10', 20000.1);
INSERT INTO `user` VALUES (13, 0x64616f206e616d6531, 0x64616f2070617373, 0x64616f2067, '2011-05-10', 1010);
INSERT INTO `user` VALUES (15, 0x64616f206e616d6532, 0x64616f207061737332, 0x64616f206732, '2011-05-10', 880);