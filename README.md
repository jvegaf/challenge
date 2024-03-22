<p align="center">
  <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" alt="project-logo">
</p>
<p align="center">
    <h1 align="center">Tech Challenge</h1>
</p>
<p align="center">
    <em>E-commerce Price Query Service</em>
</p>


| __Build Status__ | [![build](https://github.com/cicirello/Chips-n-Salsa/workflows/build/badge.svg)](https://github.com/cicirello/Chips-n-Salsa/actions/workflows/build.yml) [![docs](https://github.com/cicirello/Chips-n-Salsa/workflows/docs/badge.svg)](https://chips-n-salsa.cicirello.org/api/) [![CodeQL](https://github.com/cicirello/Chips-n-Salsa/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/cicirello/Chips-n-Salsa/actions/workflows/codeql-analysis.yml) |
| :--- | :--- |
| __JaCoCo Test Coverage__ | [![coverage](.github/badges/jacoco.svg)](https://github.com/jvegaf/challenge/actions/workflows/maven.yml) |
| __Other Information__ | [![GitHub](https://img.shields.io/github/license/jvegaf/challenge)](https://github.com/jvegaf/challenge/blob/master/LICENSE) [![style](https://img.shields.io/badge/style-Google%20Java%20Style-informational)](https://google.github.io/styleguide/javaguide.html) |




##  Features

|    |   Feature         | Description |
|----|-------------------|---------------------------------------------------------------|
| ⚙️  | **Architecture**  | The project follows a layered architecture, with a clear separation between the controller (REST) layer, service layer, and data access layer. The single responsibility principle is used to keep each layer focused on a specific task. |
| 🔩 | **Code Quality**  | The codebase demonstrates good coding practices, adhering to the Google code style guidelines. It follows a modular approach, making the codebase easy to read, understand, and maintain. Proper naming conventions and documentation enhance code readability. |
| 📄 | **Documentation** | Although not extensive, the provided documentation is sufficient for developers to understand the codebase and its components. |
| 🧩 | **Modularity**    | The codebase demonstrates good modularity, separating different components into their respective modules. This modular approach allows for easy reusability and maintainability of code. Each module focuses on a specific functionality, making it easier to understand and modify. |
| 🧪 | **Testing**       | The project includes unit tests using JUnit to verify the functionality of individual classes. It also includes some integration tests. The tests cover important features such as data storage, JSON conversion, and user interactions. |
| ⚡️  | **Performance**   | The project is designed to be efficient and responsive, with no noticeable performance issues. |
| 📦 | **Dependencies**  | Key external libraries and dependencies used in the project include Flyway for manage database migrations, and JUnit for unit testing. These dependencies provide necessary functionality and enhance development efficiency. |



---

##  Repository Structure

```sh
└── challenge/
    ├── .github
    │   ├── badges
    │   └── workflows
    ├── LICENSE
    ├── doc
    │   └── prices.http
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── src
        ├── main
        └── test
```

---

##  Getting Started

**System Requirements:**

* **Java**: `version 17.0.9`

###  Installation

<h4>From <code>source</code></h4>

> 1. Clone the challenge repository:
>
> ```console
> $ git clone https://github.com/jvegaf/challenge
> ```
>
> 2. Change to the project directory:
> ```console
> $ cd challenge
> ```
>
> 3. Install the dependencies:
> ```console
> $ mvn clean install
> ```

###  Usage

<h4>From <code>source</code></h4>

> Run challenge using the command below:
> ```console
> $ java -jar target/challenge-1.0.0.jar
> ```

###  Tests

> Run the test suite using the command below:
> ```console
> $ mvn test
> ```

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/jvegaf/challenge/issues)**: Submit bugs found or log feature requests for the `challenge` project.
- **[Submit Pull Requests](https://github.com/jvegaf/challenge/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/jvegaf/challenge/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/jvegaf/challenge
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details>
<summary>Contributor Graph</summary>
<br>
<p align="center">
   <a href="https://github.com{/jvegaf/challenge/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=jvegaf/challenge">
   </a>
</p>
</details>

---

##  License

This project released under the [MIT](https://choosealicense.com/licenses/mit) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/mit) file.


---
