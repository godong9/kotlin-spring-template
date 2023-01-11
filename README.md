# kotlin-spring-template

## Getting Started

- Run TemplateApiApplication
    - Active profiles: local
- Swagger Doc URL: http://localhost:8080/swagger-ui/index.html

## Project Structure

- Based on Clean Architecture
- Multi Module Structure
- Directory Structure
    - template-common
        - All modules depends on common module
        - Common codes likes enums, exceptions, extensions, logger, ...
        - dependencies: none
    - template-domain
        - Domain module
        - dependencies: common
    - template-application
        - Application module. Core business logic
        - dependencies: common, domain
    - template-adapter
        - Adapter module. Implements components
        - Provide WebAdapter (Transactional, Async, ...)
        - dependencies: common, domain, application
    - template-api
        - Web API module
        - dependencies: common, application, adapter
    - template-batch
        - Web Batch module
        - dependencies: common, application, adapter

## References

- [Clean Architecture Book Sample](https://github.com/wikibook/clean-architecture)
- [The Clean Architecture](https://blog.coderifleman.com/2017/12/18/the-clean-architecture/index.html)
- [Port and adapter Architecture](https://engineering.linecorp.com/ko/blog/port-and-adapter-architecture)
