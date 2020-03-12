import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Scanner;


public class PzzBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        Scanner scanner = new Scanner(System.in);
        SendMessage sendMessage = new SendMessage();
        String massage=update.getMessage().getText();
        System.out.println(update.getMessage().getText());
        if(massage.length()>0){
            sendMessage.setText("Да пососі ті піску");
        }
        sendMessage.setText(scanner.nextLine());
        sendMessage.setChatId(update.getMessage().getChatId());

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "CoursePzz_bot";
    }

    public String getBotToken() {
        return "1104774405:AAGZNZc-PYl3Va_QZLAD-c1kRUEjethHwTA";
    }
}
