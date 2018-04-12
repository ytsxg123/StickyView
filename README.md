# StickyView
用RecycleView实现的吸附效果
## 使用
 *setup1：*gradle引入
 ```
 //gradle 3.0.0以上
 implementation 'sticky:sticky_recycle:1.0.0'
 //gralde 3.0.0以下
 compile 'sticky:sticky_recycle:1.0.0'
 ```
 *setup2:* 添加ItemDecoration
 ```
 //构造为StickyView接口 适配器实现
 mRecycleView.addItemDecoration(new StickyItemDecoration(adapter));
 ```
 
