/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : bandoumovie

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-07-10 13:13:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');
INSERT INTO `admin` VALUES ('2', 'admin2', 'admin');
INSERT INTO `admin` VALUES ('3', 'admin3', 'admin');
INSERT INTO `admin` VALUES ('4', 'admin4', 'admin');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '剧情');
INSERT INTO `category` VALUES ('2', '喜剧');
INSERT INTO `category` VALUES ('3', '动作');
INSERT INTO `category` VALUES ('4', '爱情');
INSERT INTO `category` VALUES ('5', '科幻');
INSERT INTO `category` VALUES ('6', '悬疑');
INSERT INTO `category` VALUES ('7', '惊悚');
INSERT INTO `category` VALUES ('8', '恐怖');
INSERT INTO `category` VALUES ('9', '犯罪');

-- ----------------------------
-- Table structure for `groupbuy`
-- ----------------------------
DROP TABLE IF EXISTS `groupbuy`;
CREATE TABLE `groupbuy` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gid`),
  KEY `FK_GROUPBUY_MOVIE` (`mid`),
  CONSTRAINT `FK_GROUPBUY_MOVIE` FOREIGN KEY (`mid`) REFERENCES `movie` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groupbuy
-- ----------------------------
INSERT INTO `groupbuy` VALUES ('1', '1', '2019-07-09 14:55:42');
INSERT INTO `groupbuy` VALUES ('2', '2', '2019-07-09 14:55:42');
INSERT INTO `groupbuy` VALUES ('3', '3', '2019-07-10 12:53:10');
INSERT INTO `groupbuy` VALUES ('4', '1', '2019-07-10 12:54:45');
INSERT INTO `groupbuy` VALUES ('5', '1', '2019-07-10 12:55:02');
INSERT INTO `groupbuy` VALUES ('6', '2', '2019-07-10 12:55:13');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_ITEM_GROUPBUY` (`gid`),
  KEY `FK_ITEM_USER` (`uid`),
  CONSTRAINT `FK_ITEM_GROUPBUY` FOREIGN KEY (`gid`) REFERENCES `groupbuy` (`gid`),
  CONSTRAINT `FK_ITEM_USER` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '1', '1', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('2', '1', '2', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('3', '1', '3', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('4', '2', '1', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('5', '2', '2', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('6', '2', '3', '2019-07-09 14:55:42');
INSERT INTO `item` VALUES ('7', '3', '1', '2019-07-10 12:56:02');
INSERT INTO `item` VALUES ('8', '3', '2', '2019-07-10 12:56:14');
INSERT INTO `item` VALUES ('9', '3', '3', '2019-07-10 12:56:19');

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `desc` varchar(5000) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `FK_MOVIE_CATEGORY` (`cid`),
  CONSTRAINT `FK_MOVIE_CATEGORY` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '千与千寻', '日本', 'p2557573348.jpg', '千寻和爸爸妈妈一同驱车前往新家，在郊外的小路上不慎进入了神秘的隧道——他们去到了另外一个诡异世界—一个中世纪的小镇。远处飘来食物的香味，爸爸妈妈大快朵颐，孰料之后变成了猪！这时小镇上渐渐来了许多样子古怪、半透明的人。 \r\n　　千寻仓皇逃出，一个叫小白的人救了他，喂了她阻止身体消 失的药，并且告诉她怎样去找锅炉爷爷以及汤婆婆，而且必须获得一份工作才能不被魔法变成别的东西。 \r\n　　千寻在小白的帮助下幸运地获得了一份在浴池打杂的工作。渐渐她不再被那些怪模怪样的人吓倒，并从小玲那儿知道了小白是凶恶的汤婆婆的弟子。 \r\n　　一次，千寻发现小白被一群白色飞舞的纸人打伤，为了救受伤的小白，她用河神送给她的药丸驱出了小白身体内的封印以及守封印的小妖精，但小白还是没有醒过来。 \r\n　　为了救小白，千寻又踏上了她的冒险之旅。', '2019-01-27 21:27:48', '1');
INSERT INTO `movie` VALUES ('2', '这个杀手不太冷', '法国', 'p511118051.jpg', '里昂（让·雷诺饰）是名孤独的职业杀手，受人雇佣。一天，邻居家小姑娘马蒂尔达（纳塔丽·波特曼饰)敲开他的房门，要求在他那里暂避杀身之祸。原来邻居家的主人是警方缉毒组的眼线，只因贪污了一小包毒品而遭恶警（加里·奥德曼饰）杀害全家的惩罚。马蒂尔达得到里昂的留救，幸免于难，并留在里昂那里。里昂教小女孩使枪，她教里昂法文，两人关系日趋亲密，相处融洽。 \r\n　　女孩想着去报仇，反倒被抓，里昂及时赶到，将女孩救回。混杂着哀怨情仇的正邪之战渐次升级，更大的冲突在所难免……', '2019-01-27 21:29:41', '1');
INSERT INTO `movie` VALUES ('3', '肖申克的救赎', '美国', 'p480747492.jpg', '20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步…… \r\n　　本片根据著名作家斯蒂芬·金（Stephen Edwin King）的原著改编。', '2019-01-27 21:30:46', '1');
INSERT INTO `movie` VALUES ('4', '三傻大闹宝莱坞', '印度', 'p579729551.jpg', '本片根据印度畅销书作家奇坦·巴哈特（Chetan Bhagat）的处女作小说《五点人》（Five Point Someone）改编而成。法兰（马德哈万 R Madhavan 饰）、拉杜（沙曼·乔希 Sharman Joshi 饰）与兰乔（阿米尔·汗 Aamir Khan 饰）是皇家工程学院的学生，三人共居一室，结为好友。在以严格著称的学院里，兰乔是个非常与众不同的学生，他不死记硬背，甚至还公然顶撞校长“病毒”（波曼·伊拉尼 Boman Irani 饰），质疑他的教学方法。他不仅鼓动法兰与拉杜去勇敢追寻理想，还劝说校长的二女儿碧雅（卡琳娜·卡普 Kareena Kapoor 饰）离开满眼铜臭的未婚夫。兰乔的特立独行引起了模范学生“消音器”（奥米·维嘉 Omi Vaidya 饰）的不满，他约定十年后再与兰乔一决高下，看哪种生活方式更能取得成功。 \r\n　　本片获孟买电影博览奖最佳影片、最佳导演、最佳配角（波曼·伊拉尼）、最佳剧本等六项大奖，并获国际印度电影协会最佳影片、最佳导演、最佳剧情、最佳摄影等十六项大奖。', '2018-01-27 21:31:21', '2');
INSERT INTO `movie` VALUES ('5', '怦然心动', '美国', 'p663036666.jpg', '布莱斯（卡兰•麦克奥利菲 Callan McAuliffe 饰）全家搬到小镇，邻家女孩朱丽（玛德琳•卡罗尔 Madeline Carroll 饰）前来帮忙。她对他一见钟情，心愿是获得他的吻。两人是同班同学，她一直想方设法接近他，但是他避之不及。她喜欢爬在高高的梧桐树上看风景。但因为施工，树被要被砍掉，她誓死捍卫，希望他并肩作战，但是他退缩了。她的事迹上了报纸，外公对她颇有好感，令他十分困惑。她凭借鸡下蛋的项目获得了科技展第一名，成了全场焦点，令他黯然失色。她把自家鸡蛋送给他，他听家人怀疑她家鸡蛋不卫生，便偷偷把鸡蛋丢掉。她得知真相，很伤心，两人关系跌入冰点。她跟家人诉说，引发争吵。原来父亲一直攒钱照顾傻弟弟，所以生活拮据。她理解了父母，自己动手，还得到了他外公的鼎力相助。他向她道歉，但是并未解决问题。他开始关注她。鸡蛋风波未平，家庭晚宴与午餐男孩评选又把两人扯在了一起……', '2018-01-27 21:32:01', '2');
INSERT INTO `movie` VALUES ('6', '天使爱美丽', '法国', 'p2447590313.jpg', '艾米莉（奥黛丽·塔图 Audrey Tautou 饰）有着别人看来不幸的童年——父亲给她做健康检查时，发现她心跳过快，便断定她患上心脏病，从此艾米莉与学校绝缘。随后因为一桩意外，母亲在她眼前突然死去。这一切都毫不影响艾米莉对生活的豁达乐观。 \r\n　　1997年，戴安娜王妃的去世让她倍感人生的孤独脆弱，艾米莉从此开始了一系列助人计划，包括自闭忧郁的邻居老人，被老板刻薄的菜摊伙计、遗失了童年器物的旧房东、爱情失意的咖啡店同事。但她万万想不到，成人录象带商店店员尼诺（马修·卡索维 Mathieu Kassovitz 饰），竟成为她的棘手对象，艾米莉开始了令人哭笑不得的另类计划……', '2018-01-27 21:33:10', '2');
INSERT INTO `movie` VALUES ('7', '美国队长3', '美国', 'p2332503406.jpg', '美国队长史蒂夫·罗杰斯（克里斯·埃文斯 Chris Evans 饰）带领着全新组建的复仇者联盟，继续维护世界和平。然而，一次执行任务时联盟成员不小心造成大量平民伤亡，从而激发政治压力，政府决定通过一套监管系统来管理和领导复仇者联盟。联盟内部因此分裂为两派：一方由史蒂夫· 罗杰斯领导，他主张维护成员自由，在免受政府干扰的情况下保护世界；另一方则追随托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰），他令人意外地决定支持政府的监管和责任制体系。神秘莫测的巴基（塞巴斯蒂安·斯坦 Sebastian Stan 饰）似乎成为内战的关键人物……', '2018-01-27 21:55:03', '3');
INSERT INTO `movie` VALUES ('8', '奇异博士', '美国', 'p2388501883.jpg', '斯特兰奇博士（本尼迪克特·康伯巴奇 Benedict Cumberbatch 饰）是一名外科手术医生，他拥有着高超的智商和精湛的技艺，是医院乃至整个医学界的传奇人物。某一日，斯特兰奇博士遭遇了一场可怕的车祸，尽管保住了双手，但这双手伤痕累累不住颤抖，这也就意味着，他再也不能拿起手术刀，站在无影灯下了。 \r\n　　斯特兰奇博士的生活就此失去了意义陷入了绝望之中，他决定远赴尼泊尔，寻找传说中能够治愈他双手的神秘力量。在尼泊尔，风尘仆仆的斯特兰奇博士拜入了神秘的古一法师（蒂尔达·斯文顿 Tilda Swinton 饰）门下，成为了其弟子，与此同时，古一法师曾经的弟子卡西利亚斯（麦斯·米科尔森 饰）亦在虎视眈眈，企图完成他获得永生的大业。', '2018-01-27 22:11:17', '3');
INSERT INTO `movie` VALUES ('9', '钢铁侠3', '美国', 'p1955027201.jpg', '自纽约事件以来，托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰）为前所未有的焦虑症所困扰。他疯狂投入钢铁侠升级版的研发，为此废寝忘食，甚至忽略了女友佩珀·波茨（格温妮斯·帕特洛 Gwyneth Paltrow 饰）的感受。与此同时，臭名昭著的恐怖头目曼达林（本·金斯利 Ben Kingsley 饰）制造了一连串的爆炸袭击事件，托尼当年最忠诚的保镖即在最近的一次袭击中身负重伤。未过多久，托尼、佩珀以及曾与他有过一面之缘的女植物学家玛雅（丽贝卡·豪尔 Rebecca Hall 饰）在家中遭到猛烈的炮火袭击，几乎丧命，而这一切似乎都与22年前那名偶然邂逅的科学家阿尔德里奇·基连（盖·皮尔斯 Guy Pearce 饰）及其终极生物的研究有关。 \r\n　　即使有精密先进的铠甲护身，也无法排遣发自心底的焦虑。被击碎一切的托尼，如何穿越来自地狱的熊熊烈火……', '2018-01-27 22:15:37', '3');
INSERT INTO `movie` VALUES ('10', '泰坦尼克号', '美国', 'p457760035.jpg', '1912年4月10日，号称 “世界工业史上的奇迹”的豪华客轮泰坦尼克号开始了自己的处女航，从英国的南安普顿出发驶往美国纽约。富家少女罗丝（凯特•温丝莱特）与母亲及未婚夫卡尔坐上了头等舱；另一边，放荡不羁的少年画家杰克（莱昂纳多·迪卡普里奥）也在码头的一场赌博中赢得了下等舱的船票。 \r\n　　罗丝厌倦了上流社会虚伪的生活，不愿嫁给卡尔，打算投海自尽，被杰克救起。很快，美丽活泼的罗丝与英俊开朗的杰克相爱，杰克带罗丝参加下等舱的舞会、为她画像，二人的感情逐渐升温。 \r\n　　1912年4月14日，星期天晚上，一个风平浪静的夜晚。泰坦尼克号撞上了冰山，“永不沉没的”泰坦尼克号面临沉船的命运，罗丝和杰克刚萌芽的爱情也将经历生死的考验。', '2018-01-27 22:21:58', '4');
INSERT INTO `movie` VALUES ('11', '霸王别姬', '中国', 'p1910813120.jpg', '段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。 \r\n　　段小楼在认为该成家立业之时迎娶了名妓菊仙（巩俐），致使程蝶衣认定菊仙是可耻的第三者，使段小楼做了叛徒，自此，三人围绕一出《霸王别姬》生出的爱恨情仇战开始随着时代风云的变迁不断升级，终酿成悲剧。', '2018-02-04 16:29:23', '4');
INSERT INTO `movie` VALUES ('12', '美丽人生', '意大利', 'p510861873.jpg', '　犹太青年圭多（罗伯托·贝尼尼）邂逅美丽的女教师多拉（尼可莱塔·布拉斯基），他彬彬有礼的向多拉鞠躬：“早安！公主！”。历经诸多令人啼笑皆非的周折后，天遂人愿，两人幸福美满的生活在一起。 \r\n　　然而好景不长，法西斯政权下，圭多和儿子被强行送往犹太人集中营。多拉虽没有犹太血统，毅然同行，与丈夫儿子分开关押在一个集中营里。聪明乐天的圭多哄骗儿子这只是一场游戏，奖品就是一辆大坦克，儿子快乐、天真的生活在纳粹的阴霾之中。尽管集中营的生活艰苦寂寞，圭多仍然带给他人很多快乐，他还趁机在纳粹的广播里问候妻子：“早安！公主！” \r\n　　法西斯政权即将倾覆，纳粹的集中营很快就要接受最后的清理，圭多编给儿子的游戏该怎么结束？他们一家能否平安的度过这黑暗的年代呢？', '2018-02-04 16:29:59', '4');
INSERT INTO `movie` VALUES ('13', '盗梦空间', '美国', 'p513344864.jpg', '道姆·柯布（莱昂纳多·迪卡普里奥 Leonardo DiCaprio 饰）与同事阿瑟（约瑟夫·戈登-莱维特 Joseph Gordon-Levitt 饰）和纳什（卢卡斯·哈斯 Lukas Haas 饰）在一次针对日本能源大亨齐藤（渡边谦 饰）的盗梦行动中失败，反被齐藤利用。齐藤威逼利诱因遭通缉而流亡海外的柯布帮他拆分他竞争对手的公司，采取极端措施在其唯一继承人罗伯特·费希尔（希里安·墨菲 Cillian Murphy 饰）的深层潜意识中种下放弃家族公司、自立门户的想法。为了重返美国，柯布偷偷求助于岳父迈尔斯（迈克尔·凯恩 Michael Caine 饰），吸收了年轻的梦境设计师艾里阿德妮（艾伦·佩吉 Ellen Page 饰）、梦境演员艾姆斯（汤姆·哈迪 Tom Hardy 饰）和药剂师约瑟夫（迪利普·劳 Dileep Rao 饰）加入行动。在一层层递进的梦境中，柯布不仅要对付费希尔潜意识的本能反抗，还必须直面已逝妻子梅尔（玛丽昂·歌迪亚 Marion Cotillard 饰）的处处破坏，实际情况远比预想危险得多……', '2018-02-04 16:31:26', '5');
INSERT INTO `movie` VALUES ('14', '楚门的世界', '美国', 'p479682972.jpg', '楚门（金•凯瑞 Jim Carrey 饰）是一个平凡得不能再平凡的人，除了一些有些稀奇的经历之外——初恋女友突然失踪、溺水身亡的父亲忽然似乎又出现在眼前，他和绝大多数30多岁的美国男人绝无异样。这令他倍感失落。他也曾试过离开自己生活了多年的地方，但总因种种理由而不能成行。 \r\n　　直到有一天，他忽然发觉自己似乎一直在被人跟踪，无论他走到哪里，干什么事情。这种感觉愈来愈强烈。楚门决定不惜一切代价逃离这个他生活了30多年的地方，去寻找他的初恋女友。 \r\n　　但他却发现自己怎样也逃不出去。真相其实很残忍。', '2018-02-04 16:32:19', '5');
INSERT INTO `movie` VALUES ('15', '星际穿越', '美国', 'p2206088801.jpg', '近未来的地球黄沙遍野，小麦、秋葵等基础农作物相继因枯萎病灭绝，人类不再像从前那样仰望星空，放纵想象力和灵感的迸发，而是每日在沙尘暴的肆虐下倒数着所剩不多的光景。在家务农的前NASA宇航员库珀（马修·麦康纳 Matthew McConaughey 饰）接连在女儿墨菲（麦肯吉·弗依 Mackenzie Foy 饰）的书房发现奇怪的重力场现象，随即得知在某个未知区域内前NASA成员仍秘密进行一个拯救人类的计划。多年以前土星附近出现神秘虫洞，NASA借机将数名宇航员派遣到遥远的星系寻找适合居住的星球。在布兰德教授（迈克尔·凯恩 Michael Caine 饰）的劝说下，库珀忍痛告别了女儿，和其他三名专家教授女儿艾米莉亚·布兰德（安妮·海瑟薇 Anne Hathaway 饰）、罗米利（大卫·吉雅西 David Gyasi 饰）、多伊尔（韦斯·本特利 Wes Bentley 饰）搭乘宇宙飞船前往目前已知的最有希望的三颗星球考察。 \r\n　　他们穿越遥远的星系银河，感受了一小时七年光阴的沧海桑田，窥见了未知星球和黑洞的壮伟与神秘。在浩瀚宇宙的绝望而孤独角落，总有一份超越了时空的笃定情怀将他们紧紧相连……', '2018-02-04 16:34:10', '5');
INSERT INTO `movie` VALUES ('16', '龙猫', '日本', 'p2540924496.jpg', '小月的母亲生病住院了，父亲带着她与四岁的妹妹小梅到乡间的居住。她们对那里的环境都感到十分新奇，也发现了很多有趣的事情。她们遇到了很多小精灵，她们来到属于她们的环境中，看到了她们世界中很多的奇怪事物，更与一只大大胖胖的龙猫成为了朋友。龙猫与小精灵们利用他们的神奇力量，为小月与妹妹带来了很多神奇的景观，令她们大开眼界。 \r\n　　妹妹小梅常常挂念生病中的母亲，嚷着要姐姐带着她去看母亲，但小月拒绝了。小梅竟然自己前往，不料途中迷路了，小月只好寻找她的龙猫及小精灵朋友们帮助。', '2018-02-04 16:36:13', '6');
INSERT INTO `movie` VALUES ('17', '寻梦环游记', '美国', 'p2503997609.jpg', '热爱音乐的米格尔（安东尼·冈萨雷兹 Anthony Gonzalez 配音）不幸地出生在一个视音乐为洪水猛兽的大家庭之中，一家人只盼着米格尔快快长大，好继承家里传承了数代的制鞋产业。一年一度的亡灵节即将来临，每逢这一天，去世的亲人们的魂魄便可凭借着摆在祭坛上的照片返回现世和生者团圆。 \r\n　　在一场意外中，米格尔竟然穿越到了亡灵国度之中，在太阳升起之前，他必须得到一位亲人的祝福，否则就将会永远地留在这个世界里。米格尔决定去寻找已故的歌神德拉库斯（本杰明·布拉特 Benjamin Bratt 配音），因为他很有可能就是自己的祖父。途中，米格尔邂逅了落魄乐手埃克托（盖尔·加西亚·贝纳尔 Gael García Bernal 配音），也渐渐发现了德拉库斯隐藏已久的秘密。', '2018-02-04 16:37:02', '6');
INSERT INTO `movie` VALUES ('18', '神偷奶爸', '美国', 'p792776858.jpg', '超级坏蛋格鲁（史蒂夫·卡瑞尔 Steve Carell 配音）在听说埃及金字塔被盗的新闻后不满市面上新贼辈出，决定在纳法利欧博士（拉塞尔·布兰德 Russell Brand 配音）的帮助下建造火箭升空盗取月亮。在向坏蛋银行贷款的过程中，格鲁盗取的收缩射线枪被新贼维克托（杰森·席格尔 Jason Segel 配音）抢走。为了夺回收缩射线枪，格鲁决定领养三位孤儿——玛戈（米兰达·卡斯格拉夫 Miranda Cosgrove 配音）、伊迪丝（达娜·盖伊 Dana Gaier 配音）和阿格蕾丝（埃尔希·费舍 Elsie Fisher 配音），利用她们进入维克托的城堡兜售饼干的机会实施偷盗，计划成功后再偷偷处理掉三个小孩。然而在平凡的日常相处中，格鲁却发现自己越来越离不开这三个小鬼，但这样的感情用事却将严重影响周密的盗月计划……', '2018-02-04 16:39:19', '6');
INSERT INTO `movie` VALUES ('19', '七宗罪', '美国', 'p457631605.jpg', '“暴食”、“贪婪”、“懒惰”、“嫉妒”、“骄傲”、“淫欲”、“愤怒”，这是天主教教义所指的人性七宗罪。城市中发生的连坏杀人案，死者恰好都是犯有这些教义的人。凶手故弄玄虚的作案手法，令资深冷静的警员沙摩塞（摩根•弗里曼 Morgan Freeman 饰）和血气方刚的新扎警员米尔斯（布拉德•皮特 Brad Pitt 饰）都陷入了破案的谜团中。他们去图书馆研读但丁的《神曲》，企图从人间地狱的描绘中找到线索，最后从宗教文学哲学的世界中找到了凶手作案计划和手段的蛛丝马迹。凶手前来投案自首，这令众人都松了一口气，以为案件就此结束，怎料还是逃不出七宗罪的杀人逻辑，这次凶手瞄准的目标，是那个犯了“愤怒”罪的人……', '2018-02-04 16:41:46', '7');
INSERT INTO `movie` VALUES ('20', '恐怖游轮', '英国', 'p462470694.jpg', '单亲母亲杰西（梅利莎·乔治 饰）和一帮朋友乘游艇出海游玩，但她总有一种有不好的事情发生的感觉。不久，他们便在海上遭遇一场强烈的风暴。游艇翻船，众人落海，几经挣扎他们好不容易爬到游艇残骸上来。正当他们无计可施之时，一艘巨大的游轮向众人缓缓驶来。众人欣喜过望，未加思索便登上这艘名为“艾俄洛斯”的游轮，结果发现这竟是一艘1930年便告失踪的神秘之船，而船上更是空无一人。 \r\n　　随处可见的鲜血、神秘的指示以及突如其来的凶杀事件，将这群男女带入万劫不复的恐怖轮回之中……', '2018-02-04 16:46:58', '7');
INSERT INTO `movie` VALUES ('21', 'V字仇杀队', '美国', 'p1465235231.jpg', '未来的英国社会处于极权统治的高压下，不能容许同性恋者、异教徒等社会角色的存在，人民在黑暗政权下苟延残喘。 \r\n　　这晚，年轻女子艾薇（娜塔丽·波特曼 Natalie Portman饰）身陷险境，幸得V（雨果·维文 Hugo Weaving饰）相助。V是一个永远带着面具的神秘男子，拥有高智商和超凡战斗力。V继承了前革命英雄的使命，为了推翻荒唐极权的统治阶层，他成立了神秘的地下组织，摧毁了伦敦的标志性建筑，点燃了反政府的熊熊烈火。 \r\n　　艾薇和V深入接触，不仅得知了V的神秘使命，还渐渐发现原来自己的身世，注定了自己和V是同一条阵线的人。', '2018-02-04 16:48:09', '8');
INSERT INTO `movie` VALUES ('22', '蝴蝶效应', '美国', 'p2209066019.jpg', '伊万（艾什顿·库奇 Ashton Kutcher 饰）曾经有一个糟糕的童年，因为他行为闯下了大祸，令他童年充满不堪回忆的往事。而事实上，他确实只是依稀记得一点可怕的情景，这些情景一直纠缠着他的正常生活。伊万接受心理学家建议，把琐碎生活记在记事本里，却偶然发现通过记事本回到过去。 \r\n　　这时他才清楚记起，童年时候的自己做了那么多的错事。他幻想着用现在的意识，潜入童年的身体，去弥补种种过失给人们带来的伤害，尤其是希望与当年暗恋的凯西最终走回一起。然而他一次次的跨越时空的更改，只能越来越招致现实世界的不可救药。一切就像蝴蝶效应般，牵一发而动全身。', '2018-02-04 17:25:17', '8');

-- ----------------------------
-- Table structure for `remark`
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `remarkdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `FK_REMARK_USER` (`uid`),
  KEY `FK_REMARK_MOVIE` (`mid`),
  CONSTRAINT `FK_REMARK_MOVIE` FOREIGN KEY (`mid`) REFERENCES `movie` (`mid`),
  CONSTRAINT `FK_REMARK_USER` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remark
-- ----------------------------
INSERT INTO `remark` VALUES ('1', '评论1', '2019-07-09 14:55:59', '1', '3');
INSERT INTO `remark` VALUES ('2', '评论2', '2019-07-09 14:55:42', '2', '4');
INSERT INTO `remark` VALUES ('3', '评论3', '2019-07-10 12:56:56', '1', '1');
INSERT INTO `remark` VALUES ('4', '评论4', '2019-07-10 12:57:07', '1', '2');
INSERT INTO `remark` VALUES ('5', '评论5', '2019-07-10 12:57:40', '2', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL DEFAULT '1',
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user1', '123456', '张三', 'user1@qq.com', '13555512345', '上海市', '1', null);
INSERT INTO `user` VALUES ('2', 'user2', '123456', '李四', 'user2@qq.com', '13812312312', '北京市', '1', null);
INSERT INTO `user` VALUES ('3', 'user3', '123456', '王五', 'user3@qq.com', '13555512345', '上海市', '0', 'ca0f6f5a-36da-402d-8c0f-22587423de20');
INSERT INTO `user` VALUES ('4', 'user4', '123456', '赵六', 'user4@qq.com', '13876543245', '青岛市', '1', null);

-- ----------------------------
-- Table structure for `watch`
-- ----------------------------
DROP TABLE IF EXISTS `watch`;
CREATE TABLE `watch` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `watchdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`wid`),
  KEY `FK_WATCH_USER` (`uid`),
  KEY `FK_WATCH_MOVIE` (`mid`),
  CONSTRAINT `FK_WATCH_MOVIE` FOREIGN KEY (`mid`) REFERENCES `movie` (`mid`),
  CONSTRAINT `FK_WATCH_USER` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of watch
-- ----------------------------
INSERT INTO `watch` VALUES ('1', '1', '1', '2019-07-09 14:55:42');
INSERT INTO `watch` VALUES ('2', '1', '2', '2019-07-09 14:55:42');
INSERT INTO `watch` VALUES ('3', '1', '3', '2019-07-09 14:55:42');
INSERT INTO `watch` VALUES ('4', '2', '1', '2019-07-09 14:55:42');
INSERT INTO `watch` VALUES ('5', '2', '2', '2019-07-09 14:55:42');
INSERT INTO `watch` VALUES ('6', '2', '3', '2019-07-09 14:55:42');
