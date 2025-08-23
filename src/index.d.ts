declare module 'react-native-finosuvidha-account' {
    export interface StartAccountResponseProps {
        status: boolean;
        response: number;
        message: string;
    }

    export function startAccount(encToken: string, lat: string, lng: string): Promise<StartAccountResponseProps>;
}
