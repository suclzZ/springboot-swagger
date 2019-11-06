
# Swagger 生成html api文档
	
##  通过方法生成

   + 生成过程
   
    接口生成原理:
        1)使用Springfox-swagger2生成swagger.json文件
        2)使用Swagger2markup将swagger.json文件转换成asciidoc文档片段，包括（definitions.adoc、overview.adoc、paths.adoc、security.adoc）
        3)编写asciidoc的文档(主要是组装步骤2中生成的asciidoc文档片段)
        4)使用Asciidoctor将asciidoc转换成HTML或pdf

   + 引入pom依赖
           <!--swagger-->
           <dependency>
               <groupId>io.springfox</groupId>
               <artifactId>springfox-swagger-ui</artifactId>
               <version>${swagger.version}</version>
           </dependency>
           <dependency>
               <groupId>io.springfox</groupId>
               <artifactId>springfox-swagger2</artifactId>
               <version>${swagger.version}</version>
               <exclusions>
                   <exclusion>
                       <groupId>io.swagger</groupId>
                       <artifactId>swagger-annotations</artifactId>
                   </exclusion>
                   <exclusion>
                       <groupId>io.swagger</groupId>
                       <artifactId>swagger-models</artifactId>
                   </exclusion>
               </exclusions>
           </dependency>
   
           <dependency>
               <groupId>io.swagger</groupId>
               <artifactId>swagger-annotations</artifactId>
               <version>1.5.21</version>
           </dependency>
           <dependency>
               <groupId>io.swagger</groupId>
               <artifactId>swagger-models</artifactId>
               <version>1.5.21</version>
           </dependency>
   
           <dependency>
               <groupId>io.github.swagger2markup</groupId>
               <artifactId>swagger2markup-maven-plugin</artifactId>
               <version>1.3.3</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.asciidoctor</groupId>
               <artifactId>asciidoctorj</artifactId>
               <version>1.5.4.1</version>
               <scope>test</scope>
           </dependency>
         
   + 执行GenerateHtml测试方法
   
## 通过插件生成

   **很遗憾，发现springboot项目无乱如何也无法生成正常的swagger.json**

   + 生成过程
    
    1）生成swagger.json
    2) 生成snippets
    3）将asciidoc生成html、pdf
    
   + 相关配置
   
## 通过插件生成

   git示例中的项目使用的是JAX-RS，经测试也是正常

   + 生成过程
   
    1）生成swagger.json
    2) 自定义adoc模板
    3）将生成的snippets与模板结合
    4）生成html文档

   + 引入插件
   
    swagger-maven-plugin
    
   + 参考
   
    https://github.com/swagger-maven-plugin/swagger-maven-example