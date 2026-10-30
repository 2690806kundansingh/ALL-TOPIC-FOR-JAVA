/*
 * 1.What is the difference between ChatClient and ChatModel in SpringAI?

 * "ChatModel is an API that interacts with an AI model and generates responses 
 * from prompts. ChatClient is a higher-level API that provides a fluent interface 
 * to send prompts and retrieve responses easily. ChatClient can use ChatModel internally. 
 * In my project, I can use Ollama as the AI model provider."
 * 
 * Yaad rakhna, bhai: ChatModel AI model se interaction karne ki API hai, aur ChatClient 
 * us interaction ko convenient aur readable banane ka tareeka hai. Dono Spring AI mein important 
 * hain.
 * 
 * 2.what is Ollama ?
 * "Ollama is a tool that allows us to download and run large language models locally 
 * on our computer. In Spring AI applications, we can use Ollama as an AI model provider 
 * to generate responses without depending on a cloud AI API for every request."

  ==> Internal working of ChatClient and ChatModel in Spring Ai
  ==> How Open AiChatNodel is created ?
   =>We add the starter
     .org.springFramework.ai.spring-ai-starter-model-openai on the class path.
     .Spring boot then run an auto-config

   =>Auto-Configuration kicks in  
     .OpenAiChatModelConfiguration is loaded (if spring.ai.model.chat=openai,which is the default).it dinds your properties ans
      create a singleton OpenAiChatModel bean for you.

  3.what is models ?
     .Ai models are tools that learn from data to generate like
     texr,images,speech or embedding
     .Spring Ai support many types ,including text ,images,audio
      and embeddings(turning text into number for advance tasks)
      . Many supported models come pre-trained-like GPt-so you can use
      them right aeay without training your own.

   4.what is prompts 
   .A prompt is what you tell  the Ai model -like a question or 
   an instruction.
   .In spring Ai ,prompt can hanve placeholder(e.g {name}) which get
   filled with real values when tou run app -kind of like templates
    => Undeerlying APi and Abstraction 
        .Spring AI offers unified,reusable APi to handle :
           Client connections
           Vector databases
           Tool/function calling
           Observability
            Auto-configuration and Spring Boot starters
            RAG pattern

    5.Tokens 
      .Tokens are the smallest pieces of text that an Ai model understands
      .A token be a word,part of a word,or even punctuation.
      
      ==>why token Matter ?
        .Cost - Ai services charges you based on the number of tokens
               processed.
               ----More text = More tokens == More Money.
        .Limits     
             .Models have a context windows(maximum token) 
             
    6.Embeddings
      Embedding turn text,images or videos into vectors(arrays of number)
      These vectors captures meaning (not just the exact words)
         
      ==>Why use them?
         They let measure similarity by comparing distance between
         the vector
        . Useful for == Semantic search - find text/document
        .Rag (Retirenval Augmented Generation)


3.working of multiple models together ?
4.Prompting and Parsing Response in Entittes and list ?
5.Prompt default
6.Dynamic Template and Stuffing 
 .A prompt is what you send to a model: an orderes list od message
 (system/user\assostent\tool) plus options
 .A PromptTemplate is a builder that lets you define that prompt with
 placeholders,thn render it with runtime values.It can return a string
  ,a message or a full prompt ready for ChatModel.call()
  
7.Mater Prompting Templating in SPiring Ai  
  ROles
      ->User-represent-userinput
      ->System -define rule,behaviour or idenety
      ->Assistant-represtn ai response
      ->tools/functions/call

  ==>step for creating prompt
  1.create a PromptTemplate object
  2.render the template
  3.creating a prompt from the template
  4.return
  
8.Remeber This Before you build an Ai app
  ->Always pin a short ,strict system prompt in every call
  -> Seperate roles correctly: nver merge user text into system
  ->Put hard constraint in the system message about RAG
  ->Enforce length limits and truncate/summerise inputs


9.Advisor - powerfull concepts
  ->two inbuild advisor are--
    .SimpleLoggerAdvisor
    .SafeGuardAdvisor

10.Custom Advisor forCount Number of teken consumes    
 */