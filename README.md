# StickyView
用RecycleView实现的吸附效果


## 效果
![](https://img-blog.csdn.net/20180413140014257?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N1bnhpYW9nYW5nMDIxNA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
## 使用
 *setup1:* gradle引入
 ```
 //gradle 3.0.0以上
 implementation 'sticky:sticky_recycle:1.1.0'
 //gralde 3.0.0以下
 compile 'sticky:sticky_recycle:1.1.0'
 ```
 *setup2:* 添加ItemDecoration
 ```
 //构造为StickyView接口 适配器实现
 mRecycleView.addItemDecoration(new StickyItemDecoration(adapter));
 ```
 ## 更新记录
 
 ### 2018/04/13
    修复连续的两个粘连View错误显示问题
    版本1.1.0
    
 ### 2018/4/12 第一版提交
   版本 1.0.0
 
