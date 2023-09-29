
package me.jvegaf.challenge.application.price;

import java.util.List;

public record ApiError(List<String> description, Integer status) {
}
