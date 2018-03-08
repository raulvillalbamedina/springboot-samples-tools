# SPRING-INTERNATIONALIZATION

Spring configuration to use messages.properties to texts.

## Messages files

You could put files in all modules  in src/main/resources with this format in your needed module

	messages_es.properties
	messages_en.properties
	
**PLEASE THESE FILES IN UTF-8 ENCODING OR YOU COULD SEE BAD CHARACTERS**
	
## Properties format and java use

The format of the properties are

	name.of.property: Text of the property
	
In code you need the messageSource in your spring bean

	@Autowired
	private MessageSource messageSource;
    
And to use you need the locale object (setted in all requests)

Generating specific locale object
 
	messageSource.getMessage("name.of.property", null,  new Locale("es"));
	
Using a Locale object from request

	messageSource.getMessage("name.of.property", null,yourRequest.getLocale()); // if is type Locale
	messageSource.getMessage("name.of.property", null,new Locale(yourRequest.getLocale())); // if is type string
	
You could use properties with parameters with this property format

	name.of.property: The name {0} and the surname {1}

And in code with this line

	messageSource.getMessage("name.of.property", new Object[]{"Jon","Snow"},Locale.US);
	