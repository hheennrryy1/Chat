  var websocket = null;
   
  //判断当前浏览器是否支持WebSocket
  if('WebSocket' in window){
	websocket = new WebSocket("ws://119.29.193.33/Chat/websocket");
  }
  else{
	  setMessageInnerHTML("不支持");
      alert('Not support websocket')
  }
   
  //连接发生错误的回调方法
  websocket.onerror = function(){
      setMessageInnerHTML("出错");
  };
   
  //连接成功建立的回调方法
  websocket.onopen = function(event){
      setMessageInnerHTML("开始");
  }
   
  //接收到消息的回调方法
  websocket.onmessage = function(){
      setMessageInnerHTML(event.data);
  }
   
  //连接关闭的回调方法
  websocket.onclose = function(){
      setMessageInnerHTML("断开");
  }
   
  //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
  window.onbeforeunload = function(){
      websocket.close();
  }
   
  //将消息显示在网页上
  function setMessageInnerHTML(innerHTML){
      document.getElementById('message').innerHTML += innerHTML + '<br/>';
  }
  
  $(document).ready(function() {
	  //发送信息
	  $("#send-button").click(function() {
		  var message = username + ":" + $("#text").val();
		  websocket.send(message);
	  });
	  
	  //关闭连接
	  $("#close-button").click(function() {
		  websocket.close();
	  }); 
  })
  