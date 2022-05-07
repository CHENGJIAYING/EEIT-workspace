package topic;

import java.util.Scanner;

public class CRUDTest {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			System.out.println("您好,歡迎使用桃園市綠色餐廳系統\n以下系統功能選取");
			System.out.println("桃園市綠色餐廳系統:\n1.查詢 2.新增 3.修改 4.刪除 5.讀取檔案 6.關閉程式");
			while (s.hasNext()) {
				int input = s.nextInt();
				if (input <= 1) {
					System.out.println("1.單純查詢 2.查詢後輸出檔案");
					int inputq = s.nextInt();
					if (inputq <= 1) {
						System.out.println("請輸入要查詢之區域(以資料之地址為查詢依據)\nEX:'中壢區',若要查詢全部資料請輸入'桃園市'");
						String choose = s.next();
						System.err.println("顯示之資料格式為:餐廳名稱,電話,地址");
						System.out.println("以下為 " + choose + " 之查詢結果:");
						System.out.println();
						Query q = new Query();
						q.resQuery("%" + choose + "%");
						System.out.println();
						System.err.println("提示:資料若為空白則為無資料或輸入有誤請重新查詢");
						System.out.println();
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");

					} else if (inputq <= 2) {
						System.out.println("請輸入要查詢之區域(以資料之地址為查詢依據)\nEX:'中壢區',若要查詢全部資料請輸入'桃園市'");
						String write = s.next();
						System.err.println("顯示之資料格式為:餐廳名稱,電話,地址");
						System.out.println("以下為 " + write + " 之查詢結果:");
						System.out.println();
						Query q = new Query();
						q.resQuery("%" + write + "%");
						System.out.println();
						System.err.println("提示:資料若為空白則為無資料或輸入有誤請重新查詢");
						System.out.println();
						System.out.println("請輸入要輸出之完整路徑及檔名\nEX: C:\\Users\\iSpan\\Desktop\\crud\\greenew");
						String path = s.next();
						WriteFile w = new WriteFile();
						w.write("%" + write + "%", path);
						System.out.println();
						System.err.println("若指定之資料夾無檔案則可能為路徑格式輸入錯誤\n請重新查詢並依範例輸入");
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");

					} else {
						System.err.println("輸入錯誤請重新輸入");
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}

				} else if (input <= 2) {
					System.out.println("請依提示輸入要新增之餐廳");
					// System.out.println("編號");
					// int no = s.nextInt();
					System.err.println("餐廳名字");
					String name = s.next();
					System.err.println("餐廳電話");
					String phone = s.next();
					System.err.println("餐廳地址");
					String address = s.next();
					System.out.println("新增之餐廳為: " + name + " 電話: " + phone + " 地址: " + address);
					Insert i = new Insert();
					i.resInsert(name, phone, address);
					System.out.println();
					System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");

				} else if (input <= 3) {
					System.out.println("請依敘述輸入要修改之餐廳資訊\n1.更新電話 2.更新地址 3.更新名稱");
					int inputup = s.nextInt();
					if (inputup<=1) {
						System.err.println("餐廳名稱");
						String name = s.next();
						System.out.println("提示:請直接輸入新電話");
						System.err.println("新電話");
						String phone = s.next();
						Update u = new Update();
						u.resUpdate(phone, name);
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}else if (inputup<=2) {
						System.err.println("餐廳名稱");
						String name = s.next();
						System.out.println("提示:請直接輸入新地址");
						System.err.println("新地址");
						String address = s.next();
						UpdateAddress upad = new UpdateAddress();
						upad.resadUpdate(address, name);
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}else if (inputup<=3) {
						System.err.println("修改餐廳名稱請刪除後再次新增 請重新輸入");
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}else{
						System.err.println("輸入錯誤請重新輸入");
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}
					//System.out.println("請依敘述輸入要修改之餐廳資訊\n提示:若要修改餐廳名稱請刪除後再次新增");

				} else if (input <= 4) {
					System.out.println("請輸入要刪除之餐廳名稱");
					System.err.println("餐廳名稱");
					String name = s.next();
					System.out.println("是否確定要刪除 " + name);
					System.err.print("1.確定刪除 ");
					System.out.println("2.取消刪除");
					int deinput = s.nextInt();
					if (deinput <= 1) {
						Delete d = new Delete();
						d.resDelete(name);
						System.out.println();
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");

					} else if (deinput <= 2) {

						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					} else {
						System.err.println("輸入錯誤請重新輸入");
						System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
					}

				} else if (input <= 5) {
					System.out.println("請輸入要讀取之CSV檔案路徑 EX: C:\\Users\\iSpan\\Desktop\\crud\\greenew.csv");
					String path = s.next();
					System.out.println();
					ReadCSV r = new ReadCSV();
					r.read(path);
					System.out.println();
					System.out.println("桃園市綠色餐廳系統:\n1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
				} else if(input <= 6){
					System.out.println("關閉程式,感謝使用此系統");
					break;
				}else {
					System.err.println("輸入錯誤請重新輸入");
					System.out.println("1.查詢,2.新增,3.修改,4.刪除,5.讀取檔案,6.關閉程式");
				}
			}
		}
	}
}
