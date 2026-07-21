import com.sap.gateway.ip.core.customdev.util.Message
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


def Message processData(Message message) {

    String utcTime = message.getProperty("ValidNotAfter")

    DateTimeFormatter inputFormat =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")

    DateTimeFormatter outputFormat =
            DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss")

    String formattedDate = LocalDateTime.parse(utcTime, inputFormat)
            .atZone(ZoneId.of("UTC"))
            .withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
            .format(outputFormat)


    message.setProperty("AliasIST", formattedDate)

    return message
}