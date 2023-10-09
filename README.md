# rabbitmq
# learn rabbitmq
## 基于消息的通信
消息传递是一种在应用程序之间进行通信的技术。它依赖于异步消息传递，而不是基于同步请求响应的体系结构。
消息的生产者和使用者通过称为消息代理的中间消息传递层分离。
消息代理提供消息持久存储、消息过滤和消息转换等功能。
## AMQP – 高级消息队列协议（Advanced Message Queuing Protocol）
AMQP 是用于异步消息通信的开放标准线路规范。它提供了应如何构造消息的说明。
特点：
可靠和可互操作的
高度标准化的
不必依赖单一系统、单一应用程序或单一语言
只需要关心传递的消息和消息的内容
## RabbitMQ
1. Most popular implementation of AMQP
2. 强大的消息中间件
3. 提供了一个强大而灵活的平台，用于与其他消息传递进行相互操纵

发布者会将一条消息发布到交换点，后者会根据一定的路由规则或登记了相应消费者的绑定信息来讲消息的副本发到队列（或分发到多个队列）里去

### exchange
在 RabbitMQ 中，"exchange"（交换器）是用于消息路由的关键组件之一。
生产者将消息发送到交换器，而消费者从队列中接收消息。交换器负责将消息路由到一个或多个队列，这取决于所使用的路由规则。
交换器的选择取决于您的消息路由需求以及与消费者之间的关系

#### exchange types
Direct Exchange（直连交换器）：
将消息通过消息的路由键（routing key）直接发送到与之匹配的队列。

Fanout Exchange（扇形交换器）：将消息广播到所有绑定到该交换器的队列，忽略路由键。

Topic Exchange（主题交换器）：根据路由键和模式匹配规则，将消息发送到与路由键模式匹配的队列。

Headers Exchange（头交换器）：通过消息中的头部属性进行匹配，并将消息发送到匹配的队列。
### 应用
#### Configuration Queues and Exchanges with RabbitMQ

#### Configure Queues

#### Configure Topic,Fanout,Direct and Headers Exchanges

#### Configure Binding between Queues and Exchanges

#### Realize an asynchronous communication scenario using two different  applications
