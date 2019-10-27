ALTER TABLE `marvel_shopp`.`comentario` 
CHARACTER SET = utf8 , COLLATE = utf8_bin ;

CREATE TABLE `marvel_shopp`.`personagens_favorito` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `personagem` BIGINT(11) NOT NULL,
  `usuario` BIGINT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `personagem_favorito_fk_idx` (`personagem` ASC),
  INDEX `usuario_favorito_fk_idx` (`usuario` ASC),
  CONSTRAINT `personagem_favorito_fk`
    FOREIGN KEY (`personagem`)
    REFERENCES `marvel_shopp`.`personagem` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `usuario_favorito_fk`
    FOREIGN KEY (`usuario`)
    REFERENCES `marvel_shopp`.`usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
