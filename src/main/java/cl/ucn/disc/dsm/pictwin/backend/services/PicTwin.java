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

package cl.ucn.disc.dsm.pictwin.backend.services;

import cl.ucn.disc.dsm.pictwin.backend.model.Pic;
import cl.ucn.disc.dsm.pictwin.backend.model.Twin;
import cl.ucn.disc.dsm.pictwin.backend.model.User;

/**
 * The PicTwins operations
 * @author Javiera Penna-Miranda
 */
public interface PicTwin {

    /**
     * Create a User with a specific password.
     *
     * @param user to create
     * @param password to hash.
     * @return the User created.
     */

    User create (User user, String password);

    /**
     * Return authenticate User with a specific password and email.
     *
     * @param email to create
     * @param password to hash.
     * @return the User authenticate.
     */
    User authenticate (String email, String password);

    /**
     * Create a Twin with a specific pic and idUser.
     *
     * @param pic to pic
     * @param idUser to id user.
     * @return the twin created.
     */

    Twin createTwin( Pic pic, Long idUser);

    /**
     * Do a dislike with a pic in a twin.
     *
     * @param idTwin to dislike
     * @param idUser to id user the Twin.
     */
    void dislike (Long idTwin, Long idUser);

    /**
     * @return the number of users in the system
     */

    Long getUserSize();

}
