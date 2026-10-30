/*
1.what is Spring Ai ?
Definition: Spring AI is a Spring framework that helps Java 
developers integrate AI models into Spring Boot applications 
using familiar Java APIs and configuration.


==>It supports features such as:
Chat and text generation
Prompt templates
Structured output (Java objects and lists)
Embeddings
Vector databases
Retrieval-Augmented Generation (RAG)
Tool calling
Integration with different AI model providers

    =>Example-Suppose you are building an AI fitness application.
    A user enters their fitness goal, and your Spring Boot application 
    sends the prompt to an AI model and returns a workout plan.

2.what is an AI model ?
 An AI model is a trained system that processes input and produces an 
 output based on patterns learned during training.

3.what is Ollama ?
Ollama is a toll that let you download and run supported Ai
models locally on your computer

Example: you can run a supported Language model using Ollama
and connect it to your Spring Boot application thorugh Spring Ai

 =>how it works ?
  .Install Ollama
  .Dounlaod a model that your computer can run
  .Start or run the model Thorugh Ollama
  .Add the compatible Spring AI ollama dependency.
  .Configure your Spring Boot Apllicaation to connect to Ollama
  .Send prompt and recieve model responses.

 =>Note
   .Ollama is not itself the language model.It manage the local
   model runtime
   
4.Different between ChatModel and ChatClient ?

    =>ChatModel->The lower-level abstraction responsible for interacting 
    with a chat model. It accepts a prompt and returns a model response.
    Think: the model interaction API.

    =>ChatClient->ChatClient is a higher-level API that provides a fluent 
    interface for building prompts, adding messages, and retrieving responses. 
    ChatClient can use ChatModel internally. In my application, I can use either 
    API depending on the level of control I need.

    =>How ChatModel is created in Spring Ai ?
    ChatMOdel is created automatically by Spring Boot using
    Auto-configuration when you add the correct Spring Ai model
    depenedency and configure a provider such as Ollama.

    =>suppose you add the Ollama dependecny to your pom.xml and configure
    the model in spplication.properties.
    the process will work
     .1.Add Spring Ai Ollama dependency
     .2.Configure Ollama and the model
     .3.Spring Boot Auto-Configuration(Spring Ai creates and configure an OllamaChatModel bean)
     .4.Dependency Injection(you inject ChatModel or OllamaChatModel into your java class)

     => How it work internally ?
     In Spring AI, ChatModel is generally created automatically through Spring Boot auto-configuration. 
     When we add the Ollama model starter dependency and configure the model name and Ollama URL, 
     Spring AI creates an OllamaChatModel bean. Since OllamaChatModel implements 
     the ChatModel interface, we can inject ChatModel into our 
     controller and use its call() method to generate AI responses. 
     We do not need to create the object manually in a normal Spring Boot 
     application.

     .Note ->ChatModel is the interface,OllamaChatModel is its
     implimentation,and ChatClient is a higher-level API that
     can use ChatModel internally.

5.what is prompt ?
A prompt is the input given to an Ai model.It may contain a 
question,an instruction,context,or a combination of these.
The modelprocess this input and generate a respose.

=>types of prompt ?
System message: Defines the assistent's behaviour or rule
User message:Contain the user's request.
Assistent message :Represetn the assistent response or prior conversation.
Tool interaction:Represent a tool call or its result when tool calling is used.
A prompt can contain one message or several message arrange in a sequence

6.what is prompt templating?
Prompt templeting is a technique in Spring Ai that allows us to 
create a reusable prompt using placeholder and replace those
placeholder with dynaaamic values at runtime.

 =>why do we use Prompt Templating ?
 There are five important resons.
 1.Reusable->you write a prompt once and reuse it with different inputs.
 exapmle.->the same template can explain java,Python,sql,or anyother topic

 2.Dynamic input ->you application can recieve input from a user
 ,database,Rest API's or another service and insert it into prompt.

 3.Maintainbility ->
 suppose you want every answer to include an exapmle and real world use case
 instead of chanign prompts in many places,you can update one
 resuable template.

 4.Consistence responses->you can provide the the same instruction and response
 formate for every request.
 Exapmle,always ask the Ai to provide a defintion,an exapmle ans advantages.

 5.Less repetitive code
 you dont' need to create a completely new prompt string fro every user request
 .You can keep the prompt structure in one palce.

 Note->Prompt templating makes prompt construction easier and more
 consistent,but it does not gaurantee that the Ai's answer be corrected or identical.

 ==>How does Prompt Templating work internally?
 There are 4 main steps....
 1.Create a template(Explain {language} with an example)
 2.Provide dynamic values(language = "java")
 3.Render the template(Explain java with exaple)
 4.Send it to the Ai model(ChatModel sends the prompt to Ollama,which generate the respose)


7.what are Tokens ?
 
 */