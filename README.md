# tracker-domain
The tracker-domain is a project that contain the shared objects between the 
tracker-server and any plugins.   

There are several reason I am creating my own domain classes and not directly using the maven 
project classes:

- It was easier to serialize my own classes in mybatis for database storage 
than to extend the maven classes to add the additional fields I wanted to aid 
in future lookups (id).
- I don't have to worry about which constructors to use and which getters/setters may 
have hidden business logic and which return the raw values. 
- Even though I am pretty sure the maven classes are used by gradle as well I did 
want to keep open future possiblity of expansion to build systems that don't use maven 
(rake/rbenv maybe)

## Copyright and Licencing

   Copyright &copy; 2020 Scott Conway

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.