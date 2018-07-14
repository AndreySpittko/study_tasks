package exchangeService.services;

//два способи конвертувати файлик
public class StringConverter {

//    public String convert(String str){
//        String first = str.substring(str.indexOf('{'), str.indexOf(":{"));
//        String second = str.substring(str.indexOf(":{"), str.length()).replace(",\"", ",\n\t\t\"");
//
//        return first.concat(second)
//                .replace("\",\"", "\",\n\t\"")
//                .replace("{", "{\n\t")
//                .replace("}}", "\n\t}\n}")
//                .replace(":{\n\t", "{\n\t\t")
//                .replace(":", " : ");
//    }

    public String convert(String str) {
        char[] begin = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < begin.length; i++) {
            if (begin[i] == '{') {
                counter++;
            }
            if (begin[i] == '}') {
                --counter;
            }

            if (begin[i] == ':') {
                builder.append(" ")
                        .append(begin[i])
                        .append(" ");
                continue;
            }
            if(begin [i] == '}'){
                builder.append("\n");
                for(int j = 0; j < counter; j++){
                    builder.append("\t");
                }
                builder.append(begin[i]);
                continue;
            }
            builder.append(begin[i]);
            if (begin[i] == '{'
                    || begin[i] == ',') {
                builder.append("\n");
                for(int j = 0; j < counter; j++){
                    builder.append("\t");
                }
            }
        }

        return builder.toString();
    }
}
