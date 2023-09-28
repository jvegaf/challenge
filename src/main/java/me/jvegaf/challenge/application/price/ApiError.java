
package me.jvegaf.challenge.application.price;

import java.util.List;

public record ApiError(List<String> description, Integer status) {
  public ApiError(List<String> description, Integer status) {
    this.description = description;
    this.status = status;
  }
}
