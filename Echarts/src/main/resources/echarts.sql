use echarts;
drop table if exists user;
create table user
(
    id       integer primary key auto_increment,
    username varchar(20),
    password varchar(200)
);
drop table if exists people;
create table people
(
    id       integer primary key auto_increment,
    province varchar(20),
    number   integer,
    year     integer
);
# 2021
insert into people (province, number, year)
values ('北京', '2189', 2021);
insert into people (province, number, year)
values ('辽宁', '4229', 2021);
insert into people (province, number, year)
values ('吉林', '2375', 2021);
insert into people (province, number, year)
values ('黑龙江', '3125', 2021);
insert into people (province, number, year)
values ('四川', '8372', 2021);
insert into people (province, number, year)
values ('湖北', '5830', 2021);
insert into people (province, number, year)
values ('福建', '4187', 2021);
insert into people (province, number, year)
values ('广东', '12684', 2021);
insert into people (province, number, year)
values ('重庆', '3212', 2021);
insert into people (province, number, year)
values ('湖南', '6622', 2021);
insert into people (province, number, year)
values ('上海', '2489', 2021);
insert into people (province, number, year)
values ('江苏', '8505', 2021);
insert into people (province, number, year)
values ('浙江', '6540', 2021);
insert into people (province, number, year)
values ('安徽', '6113', 2021);
insert into people (province, number, year)
values ('天津', '1373', 2021);
insert into people (province, number, year)
values ('山东', '10170', 2021);
insert into people (province, number, year)
values ('山西', '3840', 2021);
insert into people (province, number, year)
values ('河南', '9883', 2021);
insert into people (province, number, year)
values ('河北', '7448', 2021);
insert into people (province, number, year)
values ('内蒙古', '2400', 2021);
insert into people (province, number, year)
values ('江西', '4517', 2021);
insert into people (province, number, year)
values ('贵州', '3852', 2021);
insert into people (province, number, year)
values ('云南', '4690', 2021);
insert into people (province, number, year)
values ('西藏', '366', 2021);
insert into people (province, number, year)
values ('陕西', '3954', 2021);
insert into people (province, number, year)
values ('甘肃', '2490', 2021);
insert into people (province, number, year)
values ('青海', '594', 2021);
insert into people (province, number, year)
values ('宁夏', '725', 2021);
insert into people (province, number, year)
values ('新疆', '2589', 2021);
insert into people (province, number, year)
values ('广西', '5037', 2021);
insert into people (province, number, year)
values ('海南', '1020', 2021);
# 2020
insert into people (province, number, year)
values ('北京', '2189', 2020);
insert into people (province, number, year)
values ('辽宁', '4259', 2020);
insert into people (province, number, year)
values ('吉林', '2407', 2020);
insert into people (province, number, year)
values ('黑龙江', '3185', 2020);
insert into people (province, number, year)
values ('四川', '8367', 2020);
insert into people (province, number, year)
values ('湖北', '5775', 2020);
insert into people (province, number, year)
values ('福建', '4154', 2020);
insert into people (province, number, year)
values ('广东', '12601', 2020);
insert into people (province, number, year)
values ('重庆', '3205', 2020);
insert into people (province, number, year)
values ('湖南', '6644', 2020);
insert into people (province, number, year)
values ('上海', '2487', 2020);
insert into people (province, number, year)
values ('江苏', '8475', 2020);
insert into people (province, number, year)
values ('浙江', '6457', 2020);
insert into people (province, number, year)
values ('安徽', '6103', 2020);
insert into people (province, number, year)
values ('天津', '1387', 2020);
insert into people (province, number, year)
values ('山东', '10153', 2020);
insert into people (province, number, year)
values ('山西', '3492', 2020);
insert into people (province, number, year)
values ('河南', '9937', 2020);
insert into people (province, number, year)
values ('河北', '7461', 2020);
insert into people (province, number, year)
values ('内蒙古', '2405', 2020);
insert into people (province, number, year)
values ('江西', '4519', 2020);
insert into people (province, number, year)
values ('贵州', '3856', 2020);
insert into people (province, number, year)
values ('云南', '4721', 2020);
insert into people (province, number, year)
values ('西藏', '364', 2020);
insert into people (province, number, year)
values ('陕西', '3953', 2020);
insert into people (province, number, year)
values ('甘肃', '2502', 2020);
insert into people (province, number, year)
values ('青海', '592', 2020);
insert into people (province, number, year)
values ('宁夏', '720', 2020);
insert into people (province, number, year)
values ('新疆', '2585', 2020);
insert into people (province, number, year)
values ('广西', '5013', 2020);
insert into people (province, number, year)
values ('海南', '1008', 2020);
# 2019
insert into people (province, number, year)
values ('北京', '2154', 2019);
insert into people (province, number, year)
values ('辽宁', '4352', 2019);
insert into people (province, number, year)
values ('吉林', '2691', 2019);
insert into people (province, number, year)
values ('黑龙江', '3751', 2019);
insert into people (province, number, year)
values ('四川', '8375', 2019);
insert into people (province, number, year)
values ('湖北', '5927', 2019);
insert into people (province, number, year)
values ('福建', '3973', 2019);
insert into people (province, number, year)
values ('广东', '11521', 2019);
insert into people (province, number, year)
values ('重庆', '3124', 2019);
insert into people (province, number, year)
values ('湖南', '6918', 2019);
insert into people (province, number, year)
values ('上海', '2428', 2019);
insert into people (province, number, year)
values ('江苏', '8070', 2019);
insert into people (province, number, year)
values ('浙江', '5850', 2019);
insert into people (province, number, year)
values ('安徽', '6366', 2019);
insert into people (province, number, year)
values ('天津', '1562', 2019);
insert into people (province, number, year)
values ('山东', '10070', 2019);
insert into people (province, number, year)
values ('山西', '3729', 2019);
insert into people (province, number, year)
values ('河南', '9640', 2019);
insert into people (province, number, year)
values ('河北', '7600', 2019);
insert into people (province, number, year)
values ('内蒙古', '2537', 2019);
insert into people (province, number, year)
values ('江西', '4666', 2019);
insert into people (province, number, year)
values ('贵州', '3623', 2019);
insert into people (province, number, year)
values ('云南', '4858', 2019);
insert into people (province, number, year)
values ('西藏', '351', 2019);
insert into people (province, number, year)
values ('陕西', '3876', 2019);
insert into people (province, number, year)
values ('甘肃', '2647', 2019);
insert into people (province, number, year)
values ('青海', '608', 2019);
insert into people (province, number, year)
values ('宁夏', '695', 2019);
insert into people (province, number, year)
values ('新疆', '2523', 2019);
insert into people (province, number, year)
values ('广西', '4960', 2019);
insert into people (province, number, year)
values ('海南', '945', 2019);
# 2018
insert into people (province, number, year)
values ('北京', '2154', 2018);
insert into people (province, number, year)
values ('辽宁', '4359', 2018);
insert into people (province, number, year)
values ('吉林', '2704', 2018);
insert into people (province, number, year)
values ('黑龙江', '3773', 2018);
insert into people (province, number, year)
values ('四川', '8341', 2018);
insert into people (province, number, year)
values ('湖北', '5917', 2018);
insert into people (province, number, year)
values ('福建', '3941', 2018);
insert into people (province, number, year)
values ('广东', '11346', 2018);
insert into people (province, number, year)
values ('重庆', '3102', 2018);
insert into people (province, number, year)
values ('湖南', '6899', 2018);
insert into people (province, number, year)
values ('上海', '2424', 2018);
insert into people (province, number, year)
values ('江苏', '8051', 2018);
insert into people (province, number, year)
values ('浙江', '5735', 2018);
insert into people (province, number, year)
values ('安徽', '6324', 2018);
insert into people (province, number, year)
values ('天津', '1560', 2018);
insert into people (province, number, year)
values ('山东', '10047', 2018);
insert into people (province, number, year)
values ('山西', '3718', 2018);
insert into people (province, number, year)
values ('河南', '9605', 2018);
insert into people (province, number, year)
values ('河北', '7556', 2018);
insert into people (province, number, year)
values ('内蒙古', '2534', 2018);
insert into people (province, number, year)
values ('江西', '4648', 2018);
insert into people (province, number, year)
values ('贵州', '3600', 2018);
insert into people (province, number, year)
values ('云南', '4830', 2018);
insert into people (province, number, year)
values ('西藏', '344', 2018);
insert into people (province, number, year)
values ('陕西', '3864', 2018);
insert into people (province, number, year)
values ('甘肃', '2637', 2018);
insert into people (province, number, year)
values ('青海', '603', 2018);
insert into people (province, number, year)
values ('宁夏', '688', 2018);
insert into people (province, number, year)
values ('新疆', '2487', 2018);
insert into people (province, number, year)
values ('广西', '4926', 2018);
insert into people (province, number, year)
values ('海南', '934', 2018);
# 2017
insert into people (province, number, year)
values ('北京', '2171', 2017);
insert into people (province, number, year)
values ('辽宁', '4369', 2017);
insert into people (province, number, year)
values ('吉林', '2717', 2017);
insert into people (province, number, year)
values ('黑龙江', '3789', 2017);
insert into people (province, number, year)
values ('四川', '8302', 2017);
insert into people (province, number, year)
values ('湖北', '5902', 2017);
insert into people (province, number, year)
values ('福建', '3911', 2017);
insert into people (province, number, year)
values ('广东', '11169', 2017);
insert into people (province, number, year)
values ('重庆', '3075', 2017);
insert into people (province, number, year)
values ('湖南', '6860', 2017);
insert into people (province, number, year)
values ('上海', '2418', 2017);
insert into people (province, number, year)
values ('江苏', '8029', 2017);
insert into people (province, number, year)
values ('浙江', '5657', 2017);
insert into people (province, number, year)
values ('安徽', '6255', 2017);
insert into people (province, number, year)
values ('天津', '1557', 2017);
insert into people (province, number, year)
values ('山东', '10006', 2017);
insert into people (province, number, year)
values ('山西', '3702', 2017);
insert into people (province, number, year)
values ('河南', '9559', 2017);
insert into people (province, number, year)
values ('河北', '7520', 2017);
insert into people (province, number, year)
values ('内蒙古', '2529', 2017);
insert into people (province, number, year)
values ('江西', '4622', 2017);
insert into people (province, number, year)
values ('贵州', '3580', 2017);
insert into people (province, number, year)
values ('云南', '4801', 2017);
insert into people (province, number, year)
values ('西藏', '337', 2017);
insert into people (province, number, year)
values ('陕西', '3835', 2017);
insert into people (province, number, year)
values ('甘肃', '2626', 2017);
insert into people (province, number, year)
values ('青海', '598', 2017);
insert into people (province, number, year)
values ('宁夏', '682', 2017);
insert into people (province, number, year)
values ('新疆', '2445', 2017);
insert into people (province, number, year)
values ('广西', '4885', 2017);
insert into people (province, number, year)
values ('海南', '926', 2017);

