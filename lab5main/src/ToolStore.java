import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ToolStore {
    public static void main(String[] args) {
        List<Tool> tools = Arrays.asList(
                new Tool("Молоток", Tool.Size.SMALL, 500),
                new Tool("Молоток", Tool.Size.LARGE, 800),
                new Tool("Гвозди", Tool.Size.MEDIUM, 200),
                new Tool("Гвозди", Tool.Size.LARGE, 300),
                new Tool("Дрель", Tool.Size.MEDIUM, 3000),
                new Tool("Ключ разводной", Tool.Size.LARGE, 1200),
                new Tool("Сверло", Tool.Size.SMALL, 400),
                new Tool("Отвертка", Tool.Size.SMALL, 250)
        );

        List<Tool> sortedByPrice = new ArrayList<>(tools);
        sortedByPrice.sort(Comparator.comparingDouble(Tool::getPrice));
        System.out.println("Сортировка по цене:");
        sortedByPrice.forEach(System.out::println);

        System.out.println("\nИнструменты до 1000 руб:");
        filterTools(tools, tool -> tool.getPrice() <= 1000).forEach(System.out::println);

        System.out.println("\nИнструменты по габаритам:");
        Map<Tool.Size, List<Tool>> bySize = tools.stream()
                .collect(Collectors.groupingBy(Tool::getSize));
        bySize.forEach((size, list) -> {
            System.out.println(size + ":");
            list.forEach(tool -> System.out.println("  " + tool));
        });

        System.out.println("\nГруппировка по номенклатуре:");
        Map<String, List<Tool>> byName = tools.stream()
                .collect(Collectors.groupingBy(Tool::getName));
        byName.forEach((name, list) -> {
            System.out.println(name + ":");
            list.forEach(tool -> System.out.println("  " + tool));
        });
    }

    // Использование интерфейса-предиката
    public static List<Tool> filterTools(List<Tool> tools, Predicate<Tool> condition) {
        return tools.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}