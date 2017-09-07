package com.abin.lee.march.svr.concurrent.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UniversalTest {
    public static void main(String[] args) {
//        String param = "{\"sendTime\":1504613426394,\"uniqKey\":\"2119891X2Doo58vg\",\"source\":\"RRD\",\"type\":\"AUDIT_REQUEST\",\"sequenceId\":0,\"data\":{\"applicationSn\":\"2119891X2Doo58vg\",\"applicationSource\":\"RRD\",\"taskType\":1,\"description\":\"首次进件\",\"loanInfo\":{},\"userBasicInfo\":{\"callHistoryJobId\":\"1d15d5b7-4ebf-4d9c-9003-b7d4f1da6ddb\",\"userKey\":\"2d500365b7bb861cf756fbf6580591c1\",\"idNo\":\"331081198908107310\",\"realName\":\"江俊辉\",\"gender\":\"MALE\",\"idCardPhotoFront\":\"https://loan.renrendai.com/Nirvana-2017-08-12/ID_CARD_POSITIVE_2119891_2017-08-12_16-49-13_1502527753246_766_face.png\",\"idCardPhotoBack\":\"https://loan.renrendai.com/Nirvana-2017-08-12/ID_CARD_NEGATIVE_2119891_2017-08-12_16-49-20_1502527760982_625_face.png\",\"idNoValidityBeginDate\":\"2011-11-25\",\"idNoValidityDate\":\"2021-11-25\",\"mobile\":\"18967608527\",\"reserveMobile\":\"18967608527\",\"email\":\"52077416@qq.com\",\"blackBoxId\":\"ewogICJ0b2tlbklkIiA6ICJock9QamRYeGI1a3UyeXlzUXlCV3hDZSt1amhQeHAzZytZVTk1YU82OWZjTm5KOEQraGFqY1pRRVo0Uys5ZGZsYlJEMUFackhrUjVxODlIXC9SbEZybFE9PSIsCiAgIm9zIiA6ICJpT1MiLAogICJwcm9maWxlVGltZSIgOiAyMTYsCiAgInZlcnNpb24iIDogIjIuMS40Igp9\",\"houseProvince\":\"10\",\"houseCity\":\"108\",\"houseDistrict\":\"1142\",\"houseAddress\":\"周康路868号御沁园西区237号\",\"homeAddress\":\"浙江省温岭市箬横镇贯庄村路东2区495号\",\"platform\":\"IOS\",\"cardNo\":\"6212261207009293176\",\"educationDegree\":\"HIGH_SCHOOL\",\"graduateDate\":\"2007-07-01\",\"loanAppNumber\":1,\"origin\":\"01001000000000000\",\"sesameOpenId\":\"268802134721543481756459935\",\"company\":\"中国平安上海分公司\",\"companyPhone\":\"58352051\",\"companyProvince\":\"上海\",\"companyCity\":\"上海市\",\"companyDistrict\":\"浦东新区\",\"companyAddress\":\"灵山路融汇89创意园1号楼\",\"companyPhoneAreacode\":\"021\",\"companyPhoneExtension\":\"\",\"companyIndustry\":null},\"subSource\":\"training\",\"emergencyContactList\":[{\"name\":\"袭祝颉\",\"mobile\":\"18217043084\",\"relation\":\"朋友\"},{\"name\":\"张诚国\",\"mobile\":\"13291681099\",\"relation\":\"朋友\"}],\"contactList\":[{\"name\":\"阿坤「T65」\",\"mobile\":\"18221293104\"},{\"name\":\"爸爸\",\"mobile\":\"13958656538\"},{\"name\":\"白钰雪\",\"mobile\":\"18553525899\"}],\"positionList\":[{\"createTime\":1502527782000,\"eventType\":\"APPLY_LOAN\",\"ipAddress\":\"117.21.168.88\",\"lng\":\"121.57914262993\",\"lat\":\"31.107798244253\",\"province\":\"上海市\",\"city\":\"上海市\",\"position\":\"上海市浦东新区周康路\"},{\"createTime\":1504613358000,\"eventType\":\"APPLY_LOAN\",\"ipAddress\":\"58.222.41.13\",\"lng\":\"\",\"lat\":\"\",\"province\":\"\",\"city\":\"\",\"position\":\"\"}],\"facePlusPlus\":{\"confidence\":85.309,\"mask_confidence\":0,\"screen_replay_confidence\":0.031,\"mask_threshold\":0.5,\"synthetic_face_confidence\":0,\"synthetic_face_threshold\":0.5,\"screen_replay_threshold\":0.5,\"face_replaced\":0,\"thresholds_1e_3\":62.169,\"thresholds_1e_4\":69.315,\"thresholds_1e_5\":74.399,\"thresholds_1e_6\":78.038},\"competitionProductsList\":[{\"appPackageName\":\"com.shuhekeji\",\"appName\":\"还呗  \",\"updateDayDiff\":\"1502528276\",\"appType\":\"LOAN\"}],\"reloan_info\":{\"is_reloan\":0}}}";
        String param = "{\"sendTime\":1500628868282,\"uniqKey\":\"705P2omRkKtttt\",\"source\":\"RRD\",\"type\":\"AUDIT_REQUEST\",\"sequenceId\":0,\"data\":{\"applicationSn\":\"705P2omRkKtttt\",\"applicationSource\":\"RRD\",\"taskType\":1,\"description\":\"\\u9996\\u6b21\\u8fdb\\u4ef6\",\"loanInfo\":{},\"userBasicInfo\":{\"callHistoryJobId\":\"a5a59e7f-5c87-42f1-9bc9-af16d58bb4b8\",\"userKey\":\"5b4dee623580ef7e45a5fa6fabd52391\",\"idNo\":\"370285199110282926\",\"realName\":\"\\u738b\\u840c\",\"gender\":\"FEMALE\",\"idCardPhotoFront\":\"http:\\/\\/172.16.1.76:8090\\/\\/Nirvana-2017-07-21\\/ID_CARD_POSITIVE_705_2017-07-21_11-50-55_1500609055215_981_id_card_front.png\",\"idCardPhotoBack\":\"http:\\/\\/172.16.1.76:8090\\/\\/Nirvana-2017-07-21\\/ID_CARD_NEGATIVE_705_2017-07-21_11-51-05_1500609065304_550_id_card_back.png\",\"idNoValidityBeginDate\":\"2012-09-06\",\"idNoValidityDate\":\"2022-09-06\",\"mobile\":\"17710390240\",\"reserveMobile\":\"17710390240\",\"email\":\"66666@qq.com\",\"houseProvince\":\"2\",\"houseCity\":\"36\",\"houseDistrict\":\"377\",\"houseAddress\":\"\\u5566\\u5566\\u5566\\u5566\",\"homeAddress\":\"\\u957f\\u6625\\u5e02\\u671d\\u9633\\u533a\\u524d\\u8fdb\\u5927\\u88572699\\u53f7\",\"platform\":\"ANDROID\",\"cardNo\":\"6217000010042791759\",\"educationDegree\":\"COLLEGE\",\"graduateDate\":\"2013-07-01\",\"loanAppNumber\":4,\"origin\":\"01001000000000000\",\"sesameOpenId\":null,\"company\":null,\"companyPhone\":null,\"companyProvince\":null,\"companyCity\":null,\"companyDistrict\":null,\"companyAddress\":null,\"companyPhoneAreacode\":null,\"companyPhoneExtension\":null,\"companyIndustry\":null},\"subSource\":\"webapp\",\"emergencyContactList\":[{\"name\":\"cc\",\"mobile\":\"15010695238\",\"relation\":\"\\u670b\\u53cb\"},{\"name\":\"JUNE\",\"mobile\":\"15899999999\",\"relation\":\"\\u670b\\u53cb\"}],\"positionList\":[{\"createTime\":1500609121000,\"eventType\":\"APPLY_LOAN\",\"ipAddress\":\"10.10.7.165\",\"lng\":\"116.3371\",\"lat\":\"39.999568\",\"province\":\"\\u5317\\u4eac\\u5e02\",\"city\":\"\\u5317\\u4eac\\u5e02\",\"position\":\"\\u4e2d\\u56fd\\u5317\\u4eac\\u5e02\\u6d77\\u6dc0\\u533a\\u4e2d\\u5173\\u6751\\u4e1c\\u8def1\\u53f7\"},{\"createTime\":1500618693000,\"eventType\":\"APPLY_LOAN\",\"ipAddress\":\"10.10.2.15\",\"lng\":\"\",\"lat\":\"\",\"province\":\"\",\"city\":\"\",\"position\":\"\"}],\"facePlusPlus\":{\"confidence\":85.16,\"mask_confidence\":0,\"screen_replay_confidence\":0,\"mask_threshold\":0.5,\"synthetic_face_confidence\":0,\"synthetic_face_threshold\":0.5,\"screen_replay_threshold\":0.5,\"face_replaced\":0,\"thresholds_1e_3\":62.169,\"thresholds_1e_4\":69.315,\"thresholds_1e_5\":74.399,\"thresholds_1e_6\":78.038},\"competitionProductsList\":[{\"appPackageName\":\"cn.com.weshare.jiekuan\",\"appName\":\"\\u95ea\\u7535\\u501f\\u6b3e\",\"updateDayDiff\":\"1500614446\"},{\"appPackageName\":\"com.hyron.b2b2p\",\"appName\":\"2345\\u8d37\\u6b3e\\u738b\",\"updateDayDiff\":\"1500614446\"},{\"appPackageName\":\"com.lingyue.YqdAndroid\",\"appName\":\"\\u73b0\\u91d1\\u501f\\u6b3e\",\"updateDayDiff\":\"1500614446\"},{\"appPackageName\":\"com.syqy.wecash\",\"appName\":\"\\u95ea\\u94f6\\t\",\"updateDayDiff\":\"1500614446\"}],\"reloan_info\":{\"is_reloan\":0}}}";


    }
}