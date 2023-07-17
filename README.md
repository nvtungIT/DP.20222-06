# Nhóm 06 - IT4536



## Thành viên trong nhóm :
### Subteam 1
* ###### Trần Xuân Đồng 20194020
* ###### Nguyễn Việt Tùng 20194208
### Subteam 2
* ###### Chu Mạnh Tiến 20194182
* ###### Nguyễn Văn Biển 20193993

## Phân công công việc
### Đối với các vấn đề liên quan đến Coupling, Cohesion, SOLID, Nhóm thực hiện theo subteam rồi trao đổi chéo giữa subteam
### Các công việc còn lại, nhóm thực hiện phân công như sau:
| Họ tên               | MSSV     | Công việc                                                                                                                               |
|----------------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Nguyễn Văn Biển      | 20193993 | Yêu cầu thêm số 2, 5 (Thêm mặt hàng Media mới, Thêm phương thức thanh toán mới: Thẻ nội địa (Domestic Card)); Giải quyết vấn đề vi phạm nguyên lý Single Responsibility Principle trong class AuthenticationController); làm báo cáo, slide                                                                         |
| Trần Xuân Đồng       | 20194020 | Yêu cầu thêm số 3 (Vấn đề Thay đổi yêu cầu khi load giao diện); Clean code (clean name, clean function - method, clear class); làm báo cáo, slide                                                                                                                                                                  |
| Chu Mạnh Tiến        | 20194182 | Yêu cầu thêm số 4, 6 (Thay đổi cách tính khoảng cách, sử dụng thư viện mới; thay đổi cách tính phí vận chuyển mới); Singleton pattern; Clean code – clean name; làm báo cáo, slide                                                                                                                                 |
| Nguyễn Việt Tùng     | 20194020 | Yêu cầu thêm số 2 (Vấn đề Thêm màn hình: Xem chi tiết sản phẩm và giải pháp); Biểu đồ usecase tổng quan; làm báo cáo, slide             |




#  An Internet Media Store
<p align="center">
  <img src="src/main/resources/assets/images/aims_cover_image.png" />
</p>

## Getting Started

Welcome to the AIMS project. Here is a guideline to help you get started.

## Folder Structure

The workspace contains the following folders, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `test`: the folder for testing purpose

## Dependency Management
### Working with Eclipse
Import the root directory of this repository after cloning under `Eclipse` -> `Open Projects from File System...` or by using EGit.

### SQLite
Import `sqlite-jdbc-3.7.2.jar` in `lib` under `Eclipse` -> `Project` -> `Properties` -> `Java Build Path` -> `Classpath` -> `Add JARs...`.


### JUnit
Import `JUnit5` library under `Eclipse` -> `Project` -> `Properties` -> `Java Build Path` -> `Modulepath` -> `Add Library...` -> `JUnit` -> `Next`.

### JavaFX
**Note:** At first, please try to run the project once, and then follow these steps.
1. Create a new `User Library` under `Eclipse` -> `Window` -> `Preferences` -> `Java` -> `Build Path` -> `User Libraries` -> `New`
2. Name it anything you want, e.g., `JavaFX15`, and include the ***jars*** under either the `lib/linux/javafx-sdk-15` directory for Linux distro or the `lib/win/javafx-sdk-15` directory for Windows in the project.
3. Include the library, e.g., `JavaFX15`, into the classpath.

### Add VM arguments
Click on `Run` -> `Run Configurations...`  -> `Java Application`, create a new launch configuration for your project and add these VM arguments:
- For Linux distro: 
> `--module-path lib/linux/javafx-sdk-15 --add-modules javafx.controls,javafx.fxml`
- For Windows:
> `--module-path lib/win/javafx-sdk-15 --add-modules javafx.controls,javafx.fxml`

## Author
- nguyenlm - Software Engeneering Student - k61
- manhvd   - Software Engeneering Student - k61
- hieudm   - ICT - k61
- thanhld  - ICT - k62
