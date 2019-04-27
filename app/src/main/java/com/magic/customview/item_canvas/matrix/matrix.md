### 矩阵乘法的理解

[Link](http://www.ruanyifeng.com/blog/2015/09/matrix-multiplication.html)

矩阵乘法

1. 不满足交换律
   `A * B != B * A`
   
2. 满足结合律
   ` (A * B) * c = A * (B * C) ` 
     
3. 满足分配律
   `A * (B + C) = A * B + A * C`
 
### Matrix 

本文来自 [Blog](http://www.gcssloop.com/customview/Matrix_Basic)

关于矩阵的计算方式，以及 Android Matrix 变换的几种方式的原理

#### Matrix简介

Matrix是一个矩阵，主要功能是坐标映射，数值转换

```

 MSCALE_X  MSKEW_X   MTRANS_X
 MSKEW_Y   MSCALE_Y  MTRANS_Y
 MPERSP_0  MPERSP_1  MPERSP_2

```

对应就是

```
X轴缩放值   X轴错切值  X轴平移值
Y轴错切值   Y轴缩放值  Y轴平移值
MPERSP_0   MPERSP_1  MPERSP_2

```

#### Matrix复合原理

 其实Matrix的多种复合操作都是使用矩阵乘法实现的，从原理上理解很简单，但是，使用矩阵乘法也有其弱点，后面的操作可能会影响到前面到操作，所以在构造Matrix时顺序很重要。
 
 我们常用的四大变换操作，每一种操作在Matrix均有三类,前乘(pre)，后乘(post)和设置(set)，可以参见文末对Matrix方法表，由于矩阵乘法不满足交换律，所以前乘(pre)，后乘(post)和设置(set)的区别还是很大的。
 
 * 前乘(pre)
   相当于将原始矩阵(M)放在前面 右边乘以 变换矩阵(S)
  
     ```
      M' = M * S 
      //M' 表示结果矩阵
     ```
   相当于矩阵的右乘
   
 * 后乘(post)
   相当于原始矩阵(M)放在后面 左边乘以 变换矩阵(S)
   
     ```
      M' = S * M 
      //M' 表示结果矩阵
     ```
    相当于矩阵的左乘
      
 * 设置(set)
   设置使用的不是矩阵乘法，而是直接覆盖掉原来的数值，所以，使用设置可能会导致之前的操作失效。
   
       


