/*
 * Copyright 2022 Javiera Peña Miranda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cl.ucn.disc.dsm.pictwin.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.ZonedDateTime;

/**
 * The Picture Image.
 *
 * @author Javiera Penna-Miranda
 */

@Entity
@Table (name = "pics")
@Builder //Replace to the constructor
@NoArgsConstructor
@AllArgsConstructor
public final class Pic {

    /**
    * The Id.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    /**
     * The instant when the Pic was saved.
     */
    @Getter
    @Builder.Default
    private ZonedDateTime timestamp = ZonedDateTime.now();

    /**
     * The amount of dislike the pic has
     */
    @Getter
    @Builder.Default
    private Integer dislikes = 0;

    /**
     * The exact number of the latitude.
     */
    @Getter
    private Double latitude;

    /**
     * The exact number of the longitude.
     */
    @Getter
    private Double longitude;

    /**
     * Number representing the error of the coordinates of the user.
     */
    @Getter
    private Double error;

    /**
     * The amount of views a pic has.
     */
    @Getter
    @Builder.Default
    private Integer views = 0;

    /**
     * The title corresponding to the pic.
     */
    @Getter
    @Setter
    private String name;

    /**
     * The corresponding bytes to the pic.
     */
    @Getter
    private byte[] picture;

    /**
     * The owner
     */
    @Getter
    @Setter
    @ManyToOne (optional = false)
    @JsonManagedReference
    private User owner;

    /**
     * The function increases the amount of dislikes whenever someone dislikes the pic.
     * @return dislikes number
     */
    public Integer incrementDislikes(){
        this.dislikes++;
        return this.dislikes;
    }

    /**
     * The function increases the amount of views whenever someone views the pic.
     * @return views number
     */
    public Integer incrementViews(){
        this.views++;
        return this.views;
    }



}
