# fileservice
文件上传服务

使用netty框架高抽象地实现断点上传
1、启动netty文件接收服务器（ServerStart启动）
   FileUploadServer：文件上传服务器
   FileUploadServerChannelInitializer：文件上传服务器初始化类，主要定义文件上传服务器读数据的处理方式
   FileUploadServerHandler：具体定义了netty读数据的细节，规定了通信对象FileTransferProtocol来协调
   UploadFileSavePath：定义不同文件类型的临时和最终存储目录
2、（FileUploadTest启动）
   FileUploadClient：文件上传客户端
   FileUploadClientChannelInitializer：文件上传客户端初始化类，主要定义文件上传客户端读数据的处理方式
   FileUploadClientHandler：具体定义了netty读数据的细节，作为客户端获取服务器返回的上传进度信息来跳过已经上传部分，实现断点续传
3、客户端读文件和服务器写文件最终也是利用了RandomAccessFile来实现
4、文件上传服务器读取transferType=0和2的数据流，发送transferType=1的数据流；文件上传客户端读取transferType=1的数据流，发送transferType=0和2的的数据流
