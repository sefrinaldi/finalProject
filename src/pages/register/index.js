import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'
import { Icon, Input, Button } from 'react-native-elements';
import { colors } from '../../utils';

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstname: "",
            lastname: "",
            email: "",
            password: ""
        }
    }

    registerHandler = () => {
        const user = {
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            email: this.state.email,
            password: this.state.password
        }

        fetch('http://localhost:8080/api/user/register', {
            method: 'POST',
            mode: 'no-cors',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user)
        }).catch(error => console.log('error', error))
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.title}>Register</Text>

                <Input
                    placeholder="First Name"
                    leftIcon={
                        <Icon
                            name='person'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                    onChangeText={firstname => this.setState({ firstname })}
                />

                <Input
                    placeholder='Last Name'
                    leftIcon={
                        <Icon
                            name='person'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                    onChangeText={lastname => this.setState({ lastname })}
                />

                <Input
                    placeholder='Email'
                    leftIcon={
                        <Icon
                            name='email'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                    onChangeText={email => this.setState({ email })}
                />

                <Input
                    placeholder='Password'
                    secureTextEntry={true}
                    leftIcon={
                        <Icon
                            name='lock'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                    onChangeText={password => this.setState({ password })}
                />

                <Button
                    title="Register"
                    titleStyle={{ fontSize: 25, color: colors.regular }}
                    type="Solid"
                    containerStyle={styles.button}
                    buttonStyle={{ marginHorizontal: 10 }}
                    onPress={this.registerHandler}
                />
            </View>
        );
    }
}

export default Register;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: colors.white,
        // justifyContent: 'center',
        alignItems: 'center'
    },
    title: {
        fontSize: 30,
        marginTop: 40,
        color: colors.primary,
        marginBottom: 20
    },
    input: {
        // borderBottomWidth: 0,
        // borderColor: colors.border,
        borderWidth: 1,
        borderRadius: 10,
        paddingHorizontal: 10,
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        // shadowRadius: 3.84,

        // elevation: 5,

    },
    button: {
        backgroundColor: colors.primary,
        width: '95%',
        borderRadius: 10
    }
})
