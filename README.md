# Lập Trình Ứng Dụng Với Java

> Repo học tập — chỉ dùng cho môn **Lập Trình Ứng Dụng Với Java** (Năm 2 - HK3).
> Không phải dự án production, chỉ chứa code thực hành theo từng chương/buổi.

## Yêu cầu môi trường

- JDK 17+ (repo đang dùng JDK 21)
- Maven 3.8+ (hoặc Maven bundled trong IntelliJ IDEA)
- IntelliJ IDEA / VS Code

## Cấu trúc

| Thư mục | Nội dung |
|---------|----------|
| `TH1/` | Bài thực hành 1 — chương trình Hello World (Maven, Java 21) |
| `Chuong2/` | Lab chương 2 — Spring Core & Dependency Injection (Maven aggregator, 3 module) |

### Chuong2 — Spring Core & DI

Mở thư mục `Chuong2` trong IntelliJ, IDE tự nhận 3 module Maven:

- `lab1-spring-di` — `@Component`/`@Bean`, Constructor Injection, DI qua interface, `@Qualifier`
- `lab2-bean-lifecycle` — thứ tự khởi tạo bean, `@PostConstruct`/`@PreDestroy`, Singleton vs Prototype
- `lab3-spring-boot` — `@SpringBootApplication`, `@Value`, `application.properties`, `CommandLineRunner`, Spring Profiles

Chạy: mở file `Main` (hoặc `Lab3Application`) của lab tương ứng → bấm ▶ cạnh `main()`.
