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
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The user of PicTwin
 *
 * @author Javiera Penna-Miranda
 */
@Entity
@Table (name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    /**
     * The email
     */
    @Getter
    @NonNull
    @NotBlank
    @Column (unique = true)
    @Setter
    private String email;

    /**
     * The password
     */
    @Getter
    @Setter
    private String password;

    /**
     * The number of strikes
     */
    @Getter
    private Integer strikes;

    /**
     * The function increases the amount of strikes by one, whenever a pic breaks a rule or is
     * considered negatively.
     *
     * @return the number of strikes
     */
    public Integer incrementStrikes(){
        this.strikes++;
        return this.strikes;
    }


    /**
     * The state that a user can have
     */
    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Getter
    @Setter
    private State state = State.ACTIVE;


    /**
     * The Twins
     */
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @Builder.Default
    @Getter
    @JsonManagedReference
    private List<Twin> twins = new ArrayList<>();

    /**
     * Insert a Twin in the list
     * @param twin to add
     */
    public void add(final Twin twin){

        this.twins.add(twin);
    }

}
