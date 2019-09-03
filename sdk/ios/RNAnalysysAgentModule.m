//
//  AnalysysReact.m
//  AnalysysReactDemo
//
//  Created by analysys on 2018/8/30.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import "RNAnalysysAgentModule.h"
#import <AnalysysAgent/AnalysysAgent.h>

@implementation RNAnalysysAgentModule

RCT_EXPORT_MODULE(RNAnalysysAgentModule)


#pragma mark *** 基本配置 ***

/**
 SDK版本信息

 React-Native示例：
 let SDKVersion = RNAnalysysAgentModule.SDKVersion()
 */
RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(SDKVersion) {
  return [AnalysysAgent SDKVersion];
}


#pragma mark *** 事件跟踪 ***

/**
 页面跟踪
 
 React-Native示例：
 RNAnalysysAgentModule.pageView("活动页", {"commodityName":"iPhone","commodityPrice":"5000"})

 @param pageName 页面名称
 @param properties 页面属性
 */
RCT_EXPORT_METHOD(pageView:(NSString *)pageName properties:(NSDictionary *)properties) {
  [AnalysysAgent pageView:pageName properties:properties];
}


/**
 事件跟踪
 
 React-Native示例：
 RNAnalysysAgentModule.track("buy", {"ptype":"iPhone","model":"Apple iPhone8"})

 @param event 事件名称
 @param properties 事件属性
 */
RCT_EXPORT_METHOD(track:(NSString *)event properties:(NSDictionary *)properties) {
  [AnalysysAgent track:event properties:properties];
}


#pragma mark *** 通用属性 ***

/**
 注册单个通用属性
 
 React-Native示例：
 RNAnalysysAgentModule.registerSuperProperty("member","VIP")

 @param superPropertyName 属性名称
 @param superPropertyValue 属性值
 */
RCT_EXPORT_METHOD(registerSuperProperty:(NSString *)superPropertyName value:(id)superPropertyValue) {
  [AnalysysAgent registerSuperProperty:superPropertyName value:superPropertyValue];
}

/**
 注册多个通用属性

 React-Native示例：
 RNAnalysysAgentModule.registerSuperProperties({"platform":"TX","age":"20"})

 @param superProperties 属性信息
 */
RCT_EXPORT_METHOD(registerSuperProperties:(NSDictionary *)superProperties) {
  [AnalysysAgent registerSuperProperties:superProperties];
}

/**
 删除单个通用属性

 React-Native示例：
 RNAnalysysAgentModule.unRegisterSuperProperty("age")

 @param superPropertyName 属性key
 */
RCT_EXPORT_METHOD(unRegisterSuperProperty:(NSString *)superPropertyName) {
  [AnalysysAgent unRegisterSuperProperty:superPropertyName];
}

/**
 清除所有通用属性

 React-Native示例：
 RNAnalysysAgentModule.clearSuperProperties()
 */
RCT_EXPORT_METHOD(clearSuperProperties) {
  [AnalysysAgent clearSuperProperties];
}

/**
 获取某个通用属性

 React-Native示例：
 let superProperty = RNAnalysysAgentModule.getSuperProperty("member")

 @param superPropertyName 属性key
 */
RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(getSuperProperty:(NSString *)superPropertyName) {
  return [AnalysysAgent getSuperProperty:superPropertyName];
}

/**
 获取已注册通用属性

 React-Native示例：
 let superProperties = RNAnalysysAgentModule.getSuperProperties()
 */
RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(getSuperProperties) {
  return [AnalysysAgent getSuperProperties];
}


#pragma mark *** 用户属性 ***

/**
 用户ID设置，长度大于0且小于255字符

 React-Native示例：
 RNAnalysysAgentModule.identify("zhangsan")

 @param distinctId 用户ID
 */
RCT_EXPORT_METHOD(identify:(NSString *)distinctId) {
  [AnalysysAgent identify:distinctId];
}

/**
 用户关联，长度大于0且小于255字符

 React-Native示例：
 RNAnalysysAgentModule.alias("newUserId","oldUserId");

 @param aliasId 将要使用的用户标识
 @param originalId 原有用户标识
 */
RCT_EXPORT_METHOD(alias:(NSString *)aliasId originalId:(NSString *)originalId) {
  [AnalysysAgent alias:aliasId originalId:originalId];
}

/**
 设置用户属性

 React-Native示例：
 RNAnalysysAgentModule.profileSet({"Email":"yonghu@163.com","WeChatID":"weixinhao"});

 @param property 属性信息
 */
RCT_EXPORT_METHOD(profileSet:(NSDictionary *)property) {
  [AnalysysAgent profileSet:property];
}

/**
 设置用户固有属性

 React-Native示例：
 RNAnalysysAgentModule.profileSetOnce({"birthday":"1995-10-01"});

 @param property 属性信息
 */
RCT_EXPORT_METHOD(profileSetOnce:(NSDictionary *)property) {
  [AnalysysAgent profileSetOnce:property];
}

/**
 设置用户属性相对变化值

 React-Native示例：
 RNAnalysysAgentModule.profileIncrement({"gameLevel": 1});

 @param property 属性信息
 */
RCT_EXPORT_METHOD(profileIncrement:(NSDictionary *)property) {
  [AnalysysAgent profileIncrement:property];
}

/**
 增加列表类型的属性

 React-Native示例：
 RNAnalysysAgentModule.profileAppend({"Hobby":"Football", "Sports":"Run"});

 @param property 属性信息
 */
RCT_EXPORT_METHOD(profileAppend:(NSDictionary *)property) {
  [AnalysysAgent profileAppend:property];
}

/**
 删除某个用户属性

 React-Native示例：
 RNAnalysysAgentModule.profileUnset("Hobby");

 @param property 属性名称
 */
RCT_EXPORT_METHOD(profileUnset:(NSString *)propertyName) {
  [AnalysysAgent profileUnset:propertyName];
}

/**
 删除当前用户的所有属性

 React-Native示例：
 RNAnalysysAgentModule.profileDelete();
 */
RCT_EXPORT_METHOD(profileDelete) {
  [AnalysysAgent profileDelete];
}


#pragma mark *** 清除本地设置 ***

/**
 清除本地设置（distinctID、aliasID、superProperties）

 React-Native示例：
 RNAnalysysAgentModule.reset()
 */
RCT_EXPORT_METHOD(reset) {
  [AnalysysAgent reset];
}





@end




